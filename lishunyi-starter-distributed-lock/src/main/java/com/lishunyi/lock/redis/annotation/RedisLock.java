package com.lishunyi.lock.redis.annotation;

import com.lishunyi.lock.Lock;

import java.lang.annotation.*;

/**
 * @AnnotationName RedisLock
 * @Description 注解类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/11/14 11:22
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/14 11:22
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Lock
public @interface RedisLock {

	/**
	 * 分布式锁的 key，必须：请保持唯一性
	 *
	 * @return key
	 */
	String value();
}
