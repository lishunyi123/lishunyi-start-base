package com.lishunyi.base.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * 自定义RestController注解
 * 数据统一返回体扫描这个注解下的方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@RestController
public @interface LsyRestController {
}
