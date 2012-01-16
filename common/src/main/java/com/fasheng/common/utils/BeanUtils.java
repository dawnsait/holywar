package com.fasheng.common.utils;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import net.sf.cglib.core.ReflectUtils;

/**
 * 高性能JavaBean属性拷贝工具类
 * 
 * @author von gosling 2011-12-24 3:58:02
 * 
 * @see org.springframework.beans.BeanUtils
 * 
 */
public abstract class BeanUtils {

	public static Object copyProperties(Object source, Class<?> target) {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		
		Object targetObject = ReflectUtils.newInstance(target);
		BeanCopier beanCopier = BeanCopier.create(source.getClass(), target,
				false);
		beanCopier.copy(source, targetObject, null);
		
		return targetObject;
	}

	public static Object copyProperties(Object source, Class<?> target,
			Converter converter) {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		
		Object targetObject = ReflectUtils.newInstance(target);
		BeanCopier beanCopier = BeanCopier.create(source.getClass(), target,
				true);
		beanCopier.copy(source, targetObject, converter);
		
		return targetObject;
	}

}
