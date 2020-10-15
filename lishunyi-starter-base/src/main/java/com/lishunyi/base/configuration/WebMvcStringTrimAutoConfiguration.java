package com.lishunyi.base.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Servlet;
import java.io.IOException;

/**
 * 控制层接收字符串前后`trim`
 *
 * @author 李顺仪
 * @version 1.0
 * @since 2020/10/15 14:32
 **/
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ConditionalOnClass({Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class})
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class WebMvcStringTrimAutoConfiguration {

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		return new Jackson2ObjectMapperBuilderCustomizer() {
			@Override
			public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
				jacksonObjectMapperBuilder
					.deserializerByType(String.class, new StdScalarDeserializer<Object>(String.class) {
						@Override
						public String deserialize(JsonParser jsonParser, DeserializationContext ctx)
							throws IOException {
							return StringUtils.trimWhitespace(jsonParser.getValueAsString());
						}
					});
			}
		};
	}

	@ControllerAdvice
	public static class ControllerStringParamTrimConfig {

		@InitBinder
		public void initBinder(WebDataBinder binder) {
			// 创建 String trim 编辑器
			// 构造方法中 boolean 参数含义为如果是空白字符串,是否转换为null
			// 即如果为true,那么 " " 会被转换为 null,否者为 ""
			StringTrimmerEditor propertyEditor = new StringTrimmerEditor(false);
			// 为String类对象注册编辑器
			binder.registerCustomEditor(String.class, propertyEditor);
		}
	}
}
