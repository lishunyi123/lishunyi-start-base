package com.lishunyi.lock.function;

import com.lishunyi.lock.exception.LockException;
import org.springframework.lang.Nullable;

/**
 * @InterfaceName CheckedSupplier
 * @Description 检查提供者
 * @Author 李顺仪
 * @CreateDate 2019/11/29 16:43
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/29 16:43
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@FunctionalInterface
public interface CheckedSupplier<T> {

	@Nullable
	T get() throws LockException;
}
