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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.holywar.model.User;
import com.holywar.service.UserService;

/**
 * @author lenovo 2011-10-31 上午1:01:46
 * 
 */
@ContextConfiguration(locations = { "classpath:bean/sys-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
public class CommonServiceTest {

	// @Autowired
	@Resource
	protected UserService userService;

	public final void setFooService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public final void testSelectUsingReflection() {
		User user = new User();
		user.setId(1);
		user = userService.findUserById(user);
		assertNotNull(user);
		assertEquals("C.Ronaldo", user.getName());
	}

	@Test
	public void testSelectUsingDom4jParser() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"sys-config.xml");

		UserService service = (UserService) ctx.getBean("userService");

		User user = new User();
		user.setId(1);

		user = service.findUserById(user);
		assertNotNull(user);
		assertEquals("gosling", user.getName());

		ctx.destroy();
	}
}
