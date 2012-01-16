package com.fasheng.queue.event;

import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * AsyncEvent,can be transfer out of jvm.
 * 
 * @author von gosling 2012-1-9 04:46:24
 */
public abstract class AsyncEvent implements Event {
    private static final long serialVersionUID = -952028962275098567L;

    private final long        timestamp;
    private final String      uuid;

    public AsyncEvent() {
        this.timestamp = System.currentTimeMillis();
        this.uuid = UUID.randomUUID().toString();
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
