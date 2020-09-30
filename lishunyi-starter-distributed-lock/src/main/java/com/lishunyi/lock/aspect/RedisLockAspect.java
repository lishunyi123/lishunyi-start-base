package com.lishunyi.lock.aspect;

import com.lishunyi.lock.redis.annotation.RedisLock;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

/**
 * @ClassName RedisLockAspect
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/11/30 13:30
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/30 13:30
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Aspect
@RequiredArgsConstructor
public class RedisLockAspect implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Around("@annotation(redisLock)")
	public Object aroundRedisLock(ProceedingJoinPoint point, RedisLock redisLock) {
		String lockName = redisLock.value();
		Assert.hasText(lockName, "@RedisLock value 不可为空");
		return null;
	}
}
