package com.lishunyi.base.jtw;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/11/6 14:34
 **/
@Data
@ApiModel(description = "token返回对象")
public class JwtTokenPair implements Serializable {

	private static final long serialVersionUID = 7010180535179451907L;

	@ApiModelProperty(value = "访问token")
	@JsonProperty("access_token")
	private String accessToken;

	@ApiModelProperty(value = "刷新token")
	@JsonProperty("refresh_token")
	private String refreshToken;

	@ApiModelProperty(value = "token类型", example = "Bearer")
	@JsonProperty("token_type")
	private String tokenType;

	@ApiModelProperty(value = "过期时间")
	private Long Expired;
}
