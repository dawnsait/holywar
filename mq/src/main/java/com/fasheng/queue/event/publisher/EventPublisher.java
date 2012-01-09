package com.fasheng.queue.event.publisher;

import com.fasheng.queue.event.AsyncEvent;

/**
 * @author vongosling 2012-1-9 05:07:45
 */
public interface EventPublisher {
    boolean publish(AsyncEvent event);
}
