package com.lishunyi.porperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @ClassName SnowflakeProperties
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/19 14:23
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/19 14:23
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "distributed.id.snowflake")
public class SnowflakeProperties implements Serializable {

	private static final long serialVersionUID = -4404151580315590502L;

	private Boolean enable = false;

	private ZookeeperProperties zookeeper;

	private Long workerID;
}
