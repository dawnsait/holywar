/**
 * Project: web
 * 
 * File Created at 2011-12-19
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
package com.fasheng.web.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * @author vongosling.fengj 2011-12-19 01:23:36
 */
public class LogbackConfigListener implements ServletContextListener {

    private static final Logger logger          = LoggerFactory
                                                        .getLogger(LogbackConfigListener.class);

    private static final String CONFIG_LOCATION = "logbackConfigLocation";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        String configLocation = event.getServletContext().getInitParameter(CONFIG_LOCATION);
        String realPath = event.getServletContext().getRealPath(configLocation);
        try {
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            loggerContext.reset();
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(loggerContext);
            joranConfigurator.doConfigure(realPath);
            logger.debug("Load slf4j configure file from {}", realPath);
        } catch (JoranException e) {
            logger.error("Can not load slf4j configure file from " + realPath, e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
