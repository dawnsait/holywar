package com.fasheng.queue.event.dispatcher;

import com.fasheng.queue.event.AsyncEvent;

/**
 * @author von gosling 2012-1-9 04:55:25
 */
public interface EventDispatcher {
    boolean dispatch(AsyncEvent event);
}
