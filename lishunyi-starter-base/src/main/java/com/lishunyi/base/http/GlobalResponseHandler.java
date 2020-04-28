package com.lishunyi.base.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName GlobalResponseHandler
 * @Description 全局响应处理
 * @Author 李顺仪
 * @CreateDate 2020/4/22 10:15
 * @UpdateUser 李顺仪
 * @UpdateDate 2020/4/22 10:15
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
		System.out.println(111);
		// 如果返回类型就是`Response`则无需处理
		return !methodParameter.getParameterType().equals(Response.class);
	}

	@Override
	public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
		// 如果返回类型为`String`需特殊处理
		if (methodParameter.getParameterType().equals(String.class)) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.writeValueAsString(Response.success(data));
			} catch (JsonProcessingException e) {
				// 返回String类型错误
			}
		}
		return Response.success(data);
	}
}