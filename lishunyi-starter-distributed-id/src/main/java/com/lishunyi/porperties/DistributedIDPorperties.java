package com.lishunyi.porperties;

import com.lishunyi.porperties.SegmentProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @ClassName DistributedIDPorperties
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/19 14:15
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/19 14:15
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "distributed.id")
public class DistributedIDPorperties implements Serializable {

	private static final long serialVersionUID = 6354267765020812700L;

	private SegmentProperties segment;

	private SnowflakeProperties snowflake;
}
