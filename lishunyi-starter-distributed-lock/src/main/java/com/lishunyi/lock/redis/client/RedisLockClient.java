package com.lishunyi.lock.redis.client;

import com.lishunyi.lock.LockType;
import com.lishunyi.lock.function.CheckedSupplier;

import java.util.concurrent.TimeUnit;

/**
 * @InterfaceName RedisLockClient
 * @Description redis锁客户端
 * @Author 李顺仪
 * @CreateDate 2019/11/29 15:09
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/29 15:09
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface RedisLockClient {

	/**
	 * 尝试获取锁
	 *
	 * @param lockName  锁名
	 * @param lockType  锁类型
	 * @param waitTime  等待时间
	 * @param leaseTime 自动解锁时间，自动解锁时间一定得大于方法执行时间
	 * @param timeUnit  时间参数
	 * @return 是否成功
	 */
	boolean tryLock(String[] lockName, LockType lockType, long waitTime, long leaseTime, TimeUnit timeUnit) throws InterruptedException;

	/**
	 * 解锁
	 *
	 * @param lockName 锁名
	 * @param lockType 锁类型
	 */
	void unLock(String[] lockName, LockType lockType);

	/**
	 * 自定获取锁后执行方法
	 *
	 * @param lockName  锁名
	 * @param lockType  锁类型
	 * @param waitTime  等待锁超时时间
	 * @param leaseTime 自动解锁时间，自动解锁时间一定得大于方法执行时间，否则会导致锁提前释放，默认100
	 * @param timeUnit  时间单位
	 * @param supplier  获取锁后的回调
	 * @return 返回的数据
	 */
	<T> T lock(String[] lockName, LockType lockType, long waitTime, long leaseTime, TimeUnit timeUnit, CheckedSupplier supplier);
}
