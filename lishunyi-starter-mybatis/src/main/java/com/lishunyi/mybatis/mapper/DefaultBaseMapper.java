package com.lishunyi.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/11/9 13:21
 **/
public interface DefaultBaseMapper<T> extends BaseMapper<T> {

	/**
	 * 全量批插入 如果不赋值会被`null`替代
	 * 不会使用数据库默认值，仅适用于mysql
	 *
	 * @param entityList 实体集合
	 * @return 影响条数
	 */
	int insertBatchSomeColumn(List<T> entityList);

	/**
	 * 全量更新，不忽略`null`
	 *
	 * @param entity 实体
	 * @return 影响条数
	 */
	int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

	/**
	 * 根据 id 逻辑删除数据,并带字段填充功能
	 *
	 * @param entity 实体
	 * @return 影响条数
	 */
	int deleteByIdWithFill(T entity);
}
