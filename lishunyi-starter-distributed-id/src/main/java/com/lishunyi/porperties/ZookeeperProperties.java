package com.lishunyi.porperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @ClassName ZookeeperProperties
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/19 14:34
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/19 14:34
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "distributed.id.snowflake.zookeeper")
public class ZookeeperProperties implements Serializable {

	private static final long serialVersionUID = -1817382290190927191L;

	private String address;

	private Integer port;
}
