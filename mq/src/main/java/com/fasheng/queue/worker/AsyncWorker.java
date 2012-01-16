package com.fasheng.queue.worker;

import java.io.Serializable;

/**
 * @author von gosling 2012-1-9 05:11:44
 */
public interface AsyncWorker {
    boolean doWork(Serializable message);
}
