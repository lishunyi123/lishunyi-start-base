package com.lishunyi.porperties;

import com.lishunyi.porperties.SegmentProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
@Data
@ConfigurationProperties(prefix = "distributed.id")
public class DistributedIDPorperties {

    private SegmentProperties segment;

    private SnowflakeProperties snowflake;
}
