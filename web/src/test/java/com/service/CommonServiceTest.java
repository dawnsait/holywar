/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;

import com.fasheng.service.service.interfaces.UserService;

/**
 * @author lenovo 2011-10-31 1:01:46
 */
@ContextConfiguration(locations = { "classpath:bean/sys-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonServiceTest {

    // @Autowired
    @Resource
    private UserService userService;

    @Test
    public void testLog() {
        //        Logger logger = (Logger) LoggerFactory.getLogger("com.service");
        //        logger.setLevel(Level.INFO);
        //        logger.warn("Low fuel level.");
        //        logger.debug("Starting search for nearest gas station.");

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(context);
        // Call context.reset() to clear any previous configuration, e.g. default 
        // configuration. For multi-step configuration, omit calling context.reset().
        context.reset();
        //configurator.doConfigure(args[0]);
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }

    @Test
    public void testSelectUsingDom4jParser() {
        //        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("sys-config.xml");
        //        System.out.println(ctx.getBean("userService"));
        //        ctx.destroy();
        Assert.assertNotNull(userService);
    }
}
