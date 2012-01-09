package com.fasheng.queue;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasheng.common.utils.ThreadUtils;
import com.fasheng.common.utils.ThreadUtils.DistinguishableThreadFactory;
import com.google.common.collect.Lists;

/**
 * @author vongosling 2012-1-9 02:32:18
 */
public class QueueConsumer {
    protected Logger                logger          = LoggerFactory.getLogger(getClass());

    protected String                queueName;
    protected int                   shutdownTimeout = Integer.MAX_VALUE;

    protected boolean               persistence     = true;
    protected String                persistencePath = System.getProperty("java.io.tmpdir")
                                                            + File.separator + "queue";
    protected Object                persistenceLock = new Object();                       //用于在backup与restore间等待的锁.

    protected BlockingQueue<Object> queue;
    protected ExecutorService       executor;

    /**
     * 任务所消费的队列名称.
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    /**
     * 停止任务时最多等待的时间, 单位为毫秒.
     */
    public void setShutdownTimeout(int shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }

    /**
     * 在JVM关闭时是否需要持久化未完成的消息到文件.
     */
    public void setPersistence(boolean persistence) {
        this.persistence = persistence;
    }

    /**
     * 系统关闭时将队列中未处理的消息持久化到文件的目录,默认为系统临时文件夹下的queue目录.
     */
    public void setPersistencePath(String persistencePath) {
        this.persistencePath = persistencePath;
    }

    /**
     * 任务初始化函数.
     */
    //@PostConstruct
    public void start() throws IOException, ClassNotFoundException, InterruptedException {

        queue = QueuesHolder.getQueue(queueName);

        if (persistence) {
            synchronized (persistenceLock) {
                restoreQueue();
            }
        }

        executor = Executors.newSingleThreadExecutor(new DistinguishableThreadFactory(
                "Queue Consumer-" + queueName));
        executor.execute((Runnable) this);
    }

    /**
     * 任务结束函数.
     */
    //@PreDestroy
    public void stop() throws IOException {
        try {
            ThreadUtils.normalShutdown(executor, shutdownTimeout, TimeUnit.MILLISECONDS);
        } finally {
            if (persistence) {
                synchronized (persistenceLock) {
                    backupQueue();
                }
            }
        }

    }

    /**
     * 保存队列中的消息到文件.
     */
    protected void backupQueue() throws IOException {
        List<Object> list = Lists.newArrayList();
        queue.drainTo(list);

        if (!list.isEmpty()) {
            ObjectOutputStream oos = null;
            try {
                File file = new File(getPersistenceDir(), getPersistenceFileName());
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                for (Object message : list) {
                    oos.writeObject(message);
                }
                logger.info("队列{}已持久化{}个消息到{}", new Object[] { queueName, list.size(),
                        file.getAbsolutePath() });
            } finally {
                if (oos != null) {
                    oos.close();
                }
            }
        } else {
            logger.debug("队列{}为空,不需要持久化 .", queueName);
        }
    }

    /**
     * 载入持久化文件中的消息到队列.
     */
    protected void restoreQueue() throws ClassNotFoundException, IOException, InterruptedException {
        ObjectInputStream ois = null;
        File file = new File(getPersistenceDir(), getPersistenceFileName());

        if (file.exists()) {
            try {
                ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                int count = 0;
                while (true) {
                    try {
                        Object message = ois.readObject();
                        queue.put(message);
                        count++;
                    } catch (EOFException e) {
                        break;
                    }
                }
                logger.info("队列{}已从{}中恢复{}个消息.", new Object[] { queueName, file.getAbsolutePath(),
                        count });
            } finally {
                if (ois != null) {
                    ois.close();
                }
            }
            file.delete();
        } else {
            logger.debug("队列{}的持久化文件{}不存在", queueName, file.getAbsolutePath());
        }
    }

    /**
     * 获取持久化文件路径. 持久化文件默认路径为java.io.tmpdir/queue/队列名.
     * 如果java.io.tmpdir/queue/目录不存在,会进行创建.
     */
    protected File getPersistenceDir() {
        File parentDir = new File(persistencePath + File.separator);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }
        return parentDir;
    }

    /**
     * 获取持久化文件的名称,默认为queueName,可重载.
     */
    protected String getPersistenceFileName() {
        return queueName;
    }
}