package com.lishunyi.mybatis.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/11/3 10:11
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public abstract class BaseTenantEntity<T extends BaseEntity<T>> extends BaseEntity<T> {

	private static final long serialVersionUID = 615751213599690599L;

	@ApiModelProperty(value = "租户ID")
	private String tenantId;
}
