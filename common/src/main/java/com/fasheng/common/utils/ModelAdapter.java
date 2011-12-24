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
package com.fasheng.common.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author lenovo 2011-12-24 下午2:41:50
 * 
 */
public abstract class ModelAdapter {

	// protected Class<?> DtoClz = GenericsUtils.getSuperClassGenricType(
	// this.getClass(), 0);
	// protected Class<?> PojoClz = GenericsUtils.getSuperClassGenricType(
	// this.getClass(), 1);

	public static void convert2Pojo(Object dto, Object pojo) {
		// BeanCopier beanCopier = BeanCopier.create(DtoClz, PojoClz, false);
		try {
			PropertyUtils.copyProperties(pojo, dto);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	};

	public static void convert2Pojo(Object dto, Object pojo, boolean convertable) {
		try {
			BeanUtils.copyProperties(pojo, dto);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	};

	public static void convert2Dto(Object pojo, Object dto) {
		try {
			PropertyUtils.copyProperties(dto, pojo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	};

	public static void convert2Dto(Object pojo, Object dto, boolean convertable) {
		try {
			BeanUtils.copyProperties(dto, pojo);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	};

}
