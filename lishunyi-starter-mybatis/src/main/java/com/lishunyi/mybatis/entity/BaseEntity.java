package com.lishunyi.mybatis.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public abstract class BaseEntity<T extends Model<T>> extends Model<T> implements Serializable {

	private static final long serialVersionUID = -9137994165169817924L;

	/**
	 * 分布式ID，不使用单表自增
	 */
	@TableId(type = IdType.ASSIGN_ID)
	@ApiModelProperty(value = "主键")
	protected Long id;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(value = "创建时间")
	protected LocalDateTime createTime;

	/**
	 * 创建人
	 */
	@TableField(fill = FieldFill.INSERT)
	@ApiModelProperty(value = "创建人")
	protected Long createBy;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@ApiModelProperty(value = "更新时间")
	protected LocalDateTime updateTime;

	/**
	 * 更新人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	@ApiModelProperty(value = "更新人")
	protected Long updateBy;

	/**
	 * 是否删除：1表示删除，0表示未删除
	 */
	@TableField("is_deleted")
	@TableLogic
	@ApiModelProperty(value = "是否删除")
	protected Boolean deleted;

	/**
	 * 版本号
	 */
	protected Long version;
}
