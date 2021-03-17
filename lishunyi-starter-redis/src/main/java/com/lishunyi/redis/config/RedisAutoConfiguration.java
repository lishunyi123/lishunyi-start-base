package com.lishunyi.redis.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/8/10 11:49
 **/
@Configuration
//@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisAutoConfiguration {

	@Value("${spring.application.name:default}")
	private String applicationName;

	@Bean
	public RedisSerializer<Object> redisSerializer(ObjectProvider<ObjectMapper> objectProvider) {
		ObjectMapper objectMapper = objectProvider.getIfAvailable(ObjectMapper::new).copy();
		objectMapper.findAndRegisterModules();
		GenericJackson2JsonRedisSerializer.registerNullValueSerializer(objectMapper, null);
		objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
		return new GenericJackson2JsonRedisSerializer(objectMapper);
	}

	@Bean
	@ConditionalOnMissingBean(RedisTemplate.class)
	public RedisTemplate<String, Serializable> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		RedisCacheConfiguration redisCacheConfiguration = config.computePrefixWith(cacheKeyPrefix())
			.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
			.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration).build();
	}

	@Bean
	public CacheKeyPrefix cacheKeyPrefix() {
		return cacheName -> applicationName.concat(":").concat(cacheName).concat(":");
	}
}
