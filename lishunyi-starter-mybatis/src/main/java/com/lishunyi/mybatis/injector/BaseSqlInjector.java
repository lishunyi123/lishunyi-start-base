package com.lishunyi.mybatis.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;

import java.util.List;

/**
 * 拓展默认的DefaultSqlInjector
 *
 * @author 李顺仪
 * @version 1.0
 * @since 2020/11/9 11:20
 **/
public class BaseSqlInjector extends DefaultSqlInjector {

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
		List<AbstractMethod> methodList = super.getMethodList(mapperClass);
		methodList.add(new InsertBatchSomeColumn());
		methodList.add(new LogicDeleteByIdWithFill());
		methodList.add(new AlwaysUpdateSomeColumnById());
		return methodList;
	}
}
