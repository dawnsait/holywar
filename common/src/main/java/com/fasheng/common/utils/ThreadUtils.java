package com.fasheng.common.utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vongosling 2012-1-9 01:38:39
 */
public class ThreadUtils {
    private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);

    /**
     * sleep等待,单位毫秒,忽略InterruptedException.
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            logger.error("Thread sleep failed", e);
        }
    }

    /**
     * @param exec
     * @param shutdownTimeout
     * @param shutdownNowTimeout
     * @param timeUnit
     */
    public static void shutdownAndAwaitTermination(ExecutorService exec, int shutdownTimeout,
                                        int shutdownNowTimeout, TimeUnit timeUnit) {
        exec.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!exec.awaitTermination(shutdownTimeout, timeUnit)) {
                exec.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!exec.awaitTermination(shutdownNowTimeout, timeUnit)) {
                    logger.error("Pool did not terminate");
                }
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            exec.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 直接调用shutdownNow的方法.
     */
    public static void normalShutdown(ExecutorService exec, int timeout, TimeUnit timeUnit) {
        try {
            dealAwaitingExeTask(exec.shutdownNow());
            if (!exec.awaitTermination(timeout, timeUnit)) {
                logger.warn("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * @param shutdownNow
     */
    private static void dealAwaitingExeTask(List<Runnable> shutdownNow) {
        logger.info("Awaiting execution task list {}", shutdownNow);
    }

    /**
     * passing a poolspecific name to the constructor so that threads from each
     * pool can be distinguished in thread dumps and error logs.
     */
    public static class DistinguishableThreadFactory implements ThreadFactory {

        private final String        prefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public DistinguishableThreadFactory(String poolName) {
            prefix = poolName + "-";
        }

        public Thread newThread(Runnable runable) {
            return new Thread(runable, prefix + threadNumber.getAndIncrement());
        }
    }
}
