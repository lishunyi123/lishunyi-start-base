package com.lishunyi.snowflake;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @ClassName SpringContextUtil
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/22 10:00
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/22 10:00
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Slf4j
public class SpringContextUtil implements ApplicationContextAware, EmbeddedValueResolverAware {
	// Spring应用上下文环境
	private static ApplicationContext applicationContext;

	private static StringValueResolver stringValueResolver;

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 实现ApplicationContextAware接口的回调方法。设置上下文环境
	 *
	 * @param applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 获取对象
	 *
	 * @param name
	 * @return Object
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}


	/**
	 * 动态获取配置文件中的值
	 *
	 * @param name
	 * @return
	 */
	public static String getPropertiesValue(String name) {
		try {
			name = "${" + name + "}";
			return stringValueResolver.resolveStringValue(name);
		} catch (Exception e) {
			log.error(String.format("当前环境变量中没有{%s}的配置", name));
			// 获取失败则返回null
			return null;
		}
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
		this.stringValueResolver = stringValueResolver;
	}
}
