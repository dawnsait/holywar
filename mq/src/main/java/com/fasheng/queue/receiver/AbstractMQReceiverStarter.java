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
package com.fasheng.queue.receiver;

import java.util.Collection;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author von gosling 2012-1-9 05:14:19
 */
public abstract class AbstractMQReceiverStarter implements ApplicationListener<ApplicationEvent>,
        ApplicationContextAware {
    private String               desiredEventClassName;
    protected ApplicationContext applicationContext;

    public void onApplicationEvent(ApplicationEvent event) {
        if (IsInterestedIn(event)) {
            final Collection<AsyncReceiver> asyncReceivers = acquireAllReceivers();
            for (AsyncReceiver receiver : asyncReceivers) {
                startReceiver(receiver);
            }
        }
    }

    protected Class<?> getDesiredType() {
        try {
            return Class.forName(desiredEventClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDesiredEventClassName() {
        return desiredEventClassName;
    }

    public void setDesiredEventClassName(String desiredEventClassName) {
        this.desiredEventClassName = desiredEventClassName;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    protected void startReceiver(AsyncReceiver receiver) {
        try {
            receiver.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean satisfiedEventType(ApplicationEvent event) {
        Class<?> clazz = getDesiredType();
        return clazz.isInstance(event);
    }

    protected abstract boolean IsInterestedIn(ApplicationEvent event);

    protected abstract Collection<AsyncReceiver> acquireAllReceivers();
}
