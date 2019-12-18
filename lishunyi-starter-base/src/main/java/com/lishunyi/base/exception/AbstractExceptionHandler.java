package com.lishunyi.base.exception;

import com.lishunyi.base.http.Response;
import com.lishunyi.base.http.ResponseCode;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @ClassName AbstractExceptionHandler
 * @Description 异常处理抽象类
 * @Author 李顺仪
 * @CreateDate 2019/12/18 13:15
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/12/18 13:15
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public abstract class AbstractExceptionHandler {

	/**
	 * 处理BindingResult
	 *
	 * @param result {@code BindingResult}
	 * @return {@code Response}
	 */
	protected Response<Object> handleException(BindingResult result) {
		FieldError error = result.getFieldError();
		assert error != null;
		String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
		return Response.error(ResponseCode.PARAM_BIND_ERROR, message);
	}

	/**
	 * 处理ConstraintViolation
	 *
	 * @param violations {@code ConstraintViolation}
	 * @return {@code Response}
	 */
	protected Response<Object> handleException(Set<ConstraintViolation<?>> violations) {
		ConstraintViolation<?> violation = violations.iterator().next();
		String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
		String message = String.format("%s:%s", path, violation.getMessage());
		return Response.error(ResponseCode.PARAM_BIND_ERROR, message);
	}
}
