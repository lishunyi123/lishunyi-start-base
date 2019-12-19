package com.lishunyi.lock.exception;

import lombok.NoArgsConstructor;

/**
 * @ClassName LockException
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/11/29 16:14
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/29 16:14
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@NoArgsConstructor
public class LockException extends RuntimeException {

	public LockException(String message) {
		super(message);
	}
}
