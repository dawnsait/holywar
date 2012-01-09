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
    protected Object                persistenceLock = new Object();                       //������backup��restore��ȴ�����.

    protected BlockingQueue<Object> queue;
    protected ExecutorService       executor;

    /**
     * ���������ѵĶ�������.
     */
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    /**
     * ֹͣ����ʱ���ȴ���ʱ��, ��λΪ����.
     */
    public void setShutdownTimeout(int shutdownTimeout) {
        this.shutdownTimeout = shutdownTimeout;
    }

    /**
     * ��JVM�ر�ʱ�Ƿ���Ҫ�־û�δ��ɵ���Ϣ���ļ�.
     */
    public void setPersistence(boolean persistence) {
        this.persistence = persistence;
    }

    /**
     * ϵͳ�ر�ʱ��������δ�������Ϣ�־û����ļ���Ŀ¼,Ĭ��Ϊϵͳ��ʱ�ļ����µ�queueĿ¼.
     */
    public void setPersistencePath(String persistencePath) {
        this.persistencePath = persistencePath;
    }

    /**
     * �����ʼ������.
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
     * �����������.
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
     * ��������е���Ϣ���ļ�.
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
                logger.info("����{}�ѳ־û�{}����Ϣ��{}", new Object[] { queueName, list.size(),
                        file.getAbsolutePath() });
            } finally {
                if (oos != null) {
                    oos.close();
                }
            }
        } else {
            logger.debug("����{}Ϊ��,����Ҫ�־û� .", queueName);
        }
    }

    /**
     * ����־û��ļ��е���Ϣ������.
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
                logger.info("����{}�Ѵ�{}�лָ�{}����Ϣ.", new Object[] { queueName, file.getAbsolutePath(),
                        count });
            } finally {
                if (ois != null) {
                    ois.close();
                }
            }
            file.delete();
        } else {
            logger.debug("����{}�ĳ־û��ļ�{}������", queueName, file.getAbsolutePath());
        }
    }

    /**
     * ��ȡ�־û��ļ�·��. �־û��ļ�Ĭ��·��Ϊjava.io.tmpdir/queue/������.
     * ���java.io.tmpdir/queue/Ŀ¼������,����д���.
     */
    protected File getPersistenceDir() {
        File parentDir = new File(persistencePath + File.separator);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }
        return parentDir;
    }

    /**
     * ��ȡ�־û��ļ�������,Ĭ��ΪqueueName,������.
     */
    protected String getPersistenceFileName() {
        return queueName;
    }
}
