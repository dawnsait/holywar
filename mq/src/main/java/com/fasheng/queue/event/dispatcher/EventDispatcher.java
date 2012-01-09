package com.fasheng.queue.event.dispatcher;

import com.fasheng.queue.event.AsyncEvent;

/**
 * @author vongosling 2012-1-9 04:55:25
 */
public interface EventDispatcher {
    boolean dispatch(AsyncEvent event);
}
