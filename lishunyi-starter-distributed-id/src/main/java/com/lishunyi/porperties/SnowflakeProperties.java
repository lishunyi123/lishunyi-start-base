package com.lishunyi.porperties;

import lombok.Data;

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
public class SnowflakeProperties {

    private Boolean enable = false;

    private ZookeeperProperties zookeeper;
}
