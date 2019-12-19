package com.lishunyi.lock;

import com.lishunyi.lock.LockType;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Lock {


	/**
	 * 分布式锁参数，可选，支持 spring el # 读取方法参数和 @ 读取 spring bean
	 *
	 * @return param
	 */
	String[] param() default "";

	/**
	 * 等待锁超时时间，默认30
	 *
	 * @return int
	 */
	long waitTime() default 30;

	/**
	 * 自动解锁时间，自动解锁时间一定得大于方法执行时间，否则会导致锁提前释放，默认100
	 *
	 * @return int
	 */
	long leaseTime() default 100;

	/**
	 * 时间单位，默认秒
	 *
	 * @return 时间
	 */
	TimeUnit timeUnit() default TimeUnit.SECONDS;

	/**
	 * 默认公平锁
	 *
	 * @return LockType
	 */
	LockType type() default LockType.FAIR;
}
