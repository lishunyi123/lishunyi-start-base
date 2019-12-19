package com.lishunyi.porperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @ClassName SegmentProperties
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/19 14:19
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/19 14:19
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "distributed.id.segment")
public class SegmentProperties implements Serializable {

	private static final long serialVersionUID = -2915650838165342532L;

	private Boolean enable = false;
}
