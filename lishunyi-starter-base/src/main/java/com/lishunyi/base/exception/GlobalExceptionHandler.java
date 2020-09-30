package com.lishunyi.base.exception;

import com.lishunyi.base.http.Response;
import com.lishunyi.base.http.ResponseCode;
import com.lishunyi.base.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.validation.ConstraintViolationException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author 李顺仪
 * @CreateDate 2019/12/18 14:03
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/12/18 14:03
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class GlobalExceptionHandler extends AbstractExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<Object> handleException(MissingServletRequestParameterException e) {
		log.warn("缺少请求的参数：{}", e.getMessage());
		String message = String.format("缺少必要的请求参数：%s", e.getParameterName());
		return Response.error(ResponseCode.PARAM_MISS, message);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<Object> handleException(MethodArgumentTypeMismatchException e) {
		log.warn("请求参数格式错误：{}", e.getMessage());
		String message = String.format("请求参数格式错误：%s", e.getName());
		return Response.error(ResponseCode.PARAM_TYPE_ERROR, message);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<Object> handleException(MethodArgumentNotValidException e) {
		log.warn("请求参数绑定失败：{}", e.getMessage());
		return handleException(e.getBindingResult());
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<Object> handleException(BindException e) {
		log.warn("请求参数绑定失败：{}", e.getMessage());
		return handleException(e.getBindingResult());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<Object> handleException(ConstraintViolationException e) {
		log.warn("参数校验失败：{}", e.getMessage());
		return handleException(e.getConstraintViolations());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Response<Object> handleException(NoHandlerFoundException e) {
		log.warn("404 找不到地址：{}", e.getMessage());
		return Response.error(ResponseCode.NOT_FOUND, e.getMessage());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<Object> handleException(HttpMessageNotReadableException e) {
		log.warn("JSON解析错误：{}", e.getMessage());
		return Response.error(ResponseCode.MSG_NOT_READABLE);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public Response<Object> handleException(HttpRequestMethodNotSupportedException e) {
		log.warn("请求方式错误：{}", e.getMessage());
		return Response.error(ResponseCode.METHOD_NOT_ALLOWED, e.getMessage());
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public Response<Object> handleException(HttpMediaTypeNotSupportedException e) {
		log.warn("不支持的媒体类型：{}", e.getMessage());
		return Response.error(ResponseCode.UNSUPPORTED_MEDIA_TYPE, e.getMessage());
	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public Response<Object> handleException(HttpMediaTypeNotAcceptableException e) {
		String message = e.getMessage() + " " + StringUtil.join(e.getSupportedMediaTypes());
		log.warn("不接受的媒体类型：{}", message);
		return Response.error(ResponseCode.UNSUPPORTED_MEDIA_TYPE, message);
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<Object> handleException(BusinessException e) {
		log.error("业务异常：{}", e.getMessage());
		return Response.error(ResponseCode.INTERNAL_SERVER_ERROR, e.getMessage());
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<Object> handleException(Throwable e) {
		log.error("未知异常：{}", e.getMessage());
		return Response.error(ResponseCode.INTERNAL_SERVER_ERROR);
	}
}
