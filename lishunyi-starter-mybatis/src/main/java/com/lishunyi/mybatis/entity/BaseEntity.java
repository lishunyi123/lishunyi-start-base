package com.lishunyi.mybatis.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @ClassName BaseEntity
 * @Description 基础实体类
 * @Author 李顺仪
 * @CreateDate 2019/10/31 9:58
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/31 9:58
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Data
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -9137994165169817924L;

	/**
	 * 分布式ID，不使用单表自增
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;

	/**
	 * 创建时间
	 * 使用jdk1.8的Instant替代Date
	 */
	@TableField(fill = FieldFill.INSERT)
	private Instant createTime;

	/**
	 * 创建人
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long createBy;

	/**
	 * 更新时间
	 * 使用jdk1.8的Instant替代Date
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Instant updateTime;

	/**
	 * 更新人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updateBy;

	/**
	 * 是否删除：1表示删除，0表示未删除
	 */
	@TableField("is_deleted")
	@TableLogic
	private Boolean deleted;

	/**
	 * 版本号
	 */
	private Long version;
}
