package com.lishunyi.lock.redis.client;

import com.lishunyi.lock.LockType;
import com.lishunyi.lock.exception.LockException;
import com.lishunyi.lock.function.CheckedSupplier;
import lombok.RequiredArgsConstructor;
import org.redisson.RedissonMultiLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisLockClientImpl
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/11/29 16:07
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/29 16:07
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@RequiredArgsConstructor
public class RedisLockClientImpl implements RedisLockClient {

	private final RedissonClient redissonClient;

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
	@Override
	public boolean tryLock(String[] lockName, LockType lockType, long waitTime, long leaseTime, TimeUnit timeUnit) throws InterruptedException {
		return this.getLock(lockName, lockType).tryLock(waitTime, leaseTime, timeUnit);
	}

	/**
	 * 解锁
	 *
	 * @param lockName 锁名
	 * @param lockType 锁类型
	 */
	@Override
	public void unLock(String[] lockName, LockType lockType) {
		this.getLock(lockName, lockType).unlock();
	}

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
	@Override
	public <T> T lock(String[] lockName, LockType lockType, long waitTime, long leaseTime, TimeUnit timeUnit, CheckedSupplier supplier) {
		try {
			boolean result = this.tryLock(lockName, lockType, waitTime, leaseTime, timeUnit);
			if (result) {
				return supplier.get();
			}
		} catch (Exception e) {
			throw new LockException(e.getMessage());
		} finally {
			this.unLock(lockName, lockType);
		}
		return null;
	}

	private RLock getLock(String[] lockName, LockType lockType) {
		RLock lock;
		switch (lockType) {
			case FAIR:
				lock = redissonClient.getFairLock(lockName[0]);
				break;
			case REENTRANT:
				lock = redissonClient.getLock(lockName[0]);
				break;
			case READ:
				RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(lockName[0]);
				lock = readWriteLock.readLock();
				break;
			case WRITE:
				readWriteLock = redissonClient.getReadWriteLock(lockName[0]);
				lock = readWriteLock.writeLock();
				break;
			case REDLOCK:
				RLock[] rLocks = new RLock[lockName.length];
				for (int i = 0; i < rLocks.length; i++) {
					rLocks[i] = redissonClient.getLock(lockName[i]);
				}
				lock = new RedissonRedLock(rLocks);
				break;
			case MULTIPLE:
				rLocks = new RLock[lockName.length];
				for (int i = 0; i < rLocks.length; i++) {
					rLocks[i] = redissonClient.getLock(lockName[i]);
				}
				lock = new RedissonMultiLock(rLocks);
				break;
			default:
				throw new LockException("找不到对应的类型 value: " + lockType);
		}
		return lock;
	}
}
