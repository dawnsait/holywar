package com.fasheng.queue.event.dispatcher;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import com.fasheng.queue.event.AsyncEvent;
import com.fasheng.queue.event.listener.EventListener;
import com.google.common.collect.Sets;

/**
 * @author vongosling 2012-1-9 04:45:10
 */
public abstract class AbstractEventDispatcher implements EventDispatcher, ApplicationContextAware {
    private static final Logger         logger         = LoggerFactory
                                                               .getLogger(AbstractEventDispatcher.class);
    protected Collection<EventListener> listeners;
    protected final Set<String>         registeredType = Sets.newHashSet();
    private ApplicationContext          applicationContext;

    protected boolean hasListener(AsyncEvent event) {
        return registeredType.contains(event.getClass().getName());
    }

    public Collection<EventListener> getAllListeners() {
        Map<String, EventListener> listenerMap = applicationContext
                .getBeansOfType(EventListener.class);
        logger.info("Get all event listeners: {}", listenerMap);
        return listenerMap.values();
    }

    protected void init() {
        listeners = getAllListeners();
        initRegisteredType();
    }

    private void initRegisteredType() {
        Assert.notEmpty(listeners, "EventListener configuration is not correct!");
        for (EventListener listener : listeners) {
            registeredType.add(listener.getHandleType());
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
