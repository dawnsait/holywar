package com.fasheng.queue.event.listener;

import com.fasheng.queue.event.AsyncEvent;

/**
 * Interface for async event listenser.
 * 
 * @author von gosling 2012-1-9 04:45:45
 */
public interface EventListener {

    void onAsyncEvent(AsyncEvent event);

    String getHandleType();
}
