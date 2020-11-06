package com.lishunyi.base.context;

import lombok.Data;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/11/5 20:20
 **/
@Data
public class LsyRequestHeader {

	private String tenantId;

	private String sourceType;
}
