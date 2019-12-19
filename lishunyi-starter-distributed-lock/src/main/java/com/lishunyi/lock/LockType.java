package com.lishunyi.lock;

/**
 * @EnumName LockType
 * @Description 锁类型
 * @Author 李顺仪
 * @CreateDate 2019/11/14 10:54
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/14 10:54
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public enum LockType {
	/**
	 * 可重入锁
	 */
	REENTRANT,
	/**
	 * 公平锁
	 */
	FAIR,
	//联锁
	MULTIPLE,
	//红锁
	REDLOCK,
	//读锁
	READ,
	//写锁
	WRITE,
	//自动模式,当参数只有一个.使用 REENTRANT 参数多个 REDLOCK
	AUTO
}
