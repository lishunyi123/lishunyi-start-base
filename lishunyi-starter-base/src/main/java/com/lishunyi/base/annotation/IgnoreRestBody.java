package com.lishunyi.base.annotation;

import java.lang.annotation.*;

/**
 * 忽略返回数据统一封装
 *
 * @author Lsy
 * @date 2021/9/3 15:09
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface IgnoreRestBody {
}
