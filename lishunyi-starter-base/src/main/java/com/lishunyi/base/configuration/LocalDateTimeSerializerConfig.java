package com.lishunyi.base.configuration;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/10/29 15:10
 **/
@Configuration
public class LocalDateTimeSerializerConfig {
	@Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
	private String pattern;

	@Bean
	public LocalDateTimeSerializer localDateTimeDeserializer() {
		return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
	}

	/*@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
	}*/
}
