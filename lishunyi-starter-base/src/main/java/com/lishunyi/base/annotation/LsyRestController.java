package com.lishunyi.base.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * 自定义RestController注解
 * 该注解下的方法会包装统一消息返回体{@link com.lishunyi.base.http.Response}
 *
 * @author LSY
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@RestController
public @interface LsyRestController {
}
