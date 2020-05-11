package com.lishunyi.base.exception;

import com.lishunyi.base.http.Response;
import com.lishunyi.base.http.ResponseCode;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/5/11 17:18
 **/
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 868103911654271412L;

	private final Response<?> response;

	public BusinessException(Response<?> response) {
		super(response.getMsg());
		this.response = response;
	}

	public BusinessException(ResponseCode code) {
		this(code, code.getMsg());
	}

	public BusinessException(ResponseCode code, String message) {
		super(message);
		this.response = Response.error(code, message);
	}

	public BusinessException(String message) {
		super(message);
		this.response = Response.error(message);
	}
}
