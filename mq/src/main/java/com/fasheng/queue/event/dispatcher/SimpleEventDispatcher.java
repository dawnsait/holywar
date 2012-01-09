package com.fasheng.queue.event.dispatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasheng.queue.event.AsyncEvent;
import com.fasheng.queue.event.listener.EventListener;

/**
 * One simple implenmentation of {@link EventDispatcher}, no thread pool
 * internal.
 * 
 * @author vongosling 2012-1-9 05:03:17
 */
public class SimpleEventDispatcher extends AbstractEventDispatcher {
    private static final Logger logger = LoggerFactory.getLogger(AsyncEventDispatcher.class);

    //if no exception occor, we think the event process is successful.
    public boolean dispatch(final AsyncEvent event) {
        if (hasListener(event)) {
            multicastEvent(event);
        } else {
            logger.error("No listener can handle this event", event);
        }
        return true;
    }

    private void multicastEvent(final AsyncEvent event) {
        for (final EventListener listener : listeners) {
            listener.onAsyncEvent(event);
        }
    }

    public void init() {
        super.init();
    }

    public void shutdown() {
        logger.debug("SimpleEventDispatcher shutdown.");
    }

}
