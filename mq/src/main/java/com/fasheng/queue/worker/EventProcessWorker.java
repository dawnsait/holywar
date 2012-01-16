package com.fasheng.queue.worker;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasheng.queue.event.AsyncEvent;
import com.fasheng.queue.event.dispatcher.EventDispatcher;

/**
 * @author von gosling 2012-1-9 05:12:24
 */
public class EventProcessWorker implements AsyncWorker {
    private static final Logger logger = LoggerFactory.getLogger(EventProcessWorker.class);
    private EventDispatcher     eventDispatcher;

    public boolean doWork(Serializable message) {
        logger.info("Receiving messages: {}", message);
        try {
            AsyncEvent event = (AsyncEvent) message;
            eventDispatcher.dispatch(event);
        } catch (Exception e) {
            logger.error("Process event error: ", e);
        }
        return true;
    }

    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }
}
