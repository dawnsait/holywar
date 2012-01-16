/**
 * Project: mq
 * 
 * File Created at 2012-1-9
 * $Id$
 * 
 * Copyright 2011 Alibaba.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.fasheng.queue.event.dispatcher;

import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasheng.common.utils.Assert;
import com.fasheng.queue.event.AsyncEvent;
import com.fasheng.queue.event.listener.EventListener;

/**
 * Default {@link EventDispatcher} implementation. It will multicast the event to
 * all listenrs which already registered. <br/>
 * <b>Notice, handle unexpected errors is the responsiblity of listeners.</b>
 * 
 * @author von gosling 2012-1-9 05:00:26
 */
public class AsyncEventDispatcher extends AbstractEventDispatcher {
    private static final Logger logger = LoggerFactory.getLogger(AsyncEventDispatcher.class);
    private ExecutorService     executor;

    //if no exception occor, we think the event process is successful.
    public boolean dispatch(final AsyncEvent event) {
        if (hasListener(event)) {
            multicastEvent(event);
        } else {
            logger.error("No listener can handle this event", event);
        }
        return true;
    }

    public void init() {
        super.init();
        Assert.notNull(executor, "event process pool not init properly!");
    }

    public void shutdown() {
        logger.debug("AsyncEventDispatcher shutdown ...");
        executor.shutdown();
    }

    private void multicastEvent(final AsyncEvent event) {
        for (final EventListener listener : listeners) {
            executor.execute(new Runnable() {
                public void run() {
                    listener.onAsyncEvent(event);
                }
            });
        }
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }
}
