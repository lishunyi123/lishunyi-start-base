package com.lishunyi.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.lishunyi.mybatis.injector.BaseSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusConfig
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/23 14:50
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/23 14:50
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Configuration
public class MybatisPlusConfig {

	/**
	 * 插件
	 *
	 * @return
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

		PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
		paginationInnerInterceptor.setMaxLimit(1000L);
		interceptor.addInnerInterceptor(paginationInnerInterceptor);
		return interceptor;
	}

	/**
	 * 使用自定义的BaseSqlInjector
	 *
	 * @return BaseSqlInjector
	 */
	@Bean
	public BaseSqlInjector baseSqlInjector() {
		return new BaseSqlInjector();
	}
}

