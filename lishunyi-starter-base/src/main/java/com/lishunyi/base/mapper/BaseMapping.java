package com.lishunyi.base.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MapperConfig;

import java.util.List;
import java.util.stream.Stream;

/**
 * base转换接口
 *
 * @author 李顺仪
 * @version 1.0
 * @since 2020/11/30 14:54
 **/
@MapperConfig
public interface BaseMapping<S, T> {

	/**
	 * 映射同名属性
	 *
	 * @param source 来源
	 * @return 目标
	 */
	T sourceToTarget(S source);

	/**
	 * 反向，映射同名属性
	 *
	 * @param target 目标
	 * @return 来源
	 */
	@InheritInverseConfiguration(name = "sourceToTarget")
	S targetToSource(T target);

	@InheritConfiguration(name = "sourceToTarget")
	List<T> sourceToTarget(List<S> sources);

	@InheritConfiguration(name = "targetToSource")
	List<S> targetToSource(List<T> targets);

	List<T> sourceToTarget(Stream<S> stream);

	List<S> targetToSource(Stream<S> stream);
}
