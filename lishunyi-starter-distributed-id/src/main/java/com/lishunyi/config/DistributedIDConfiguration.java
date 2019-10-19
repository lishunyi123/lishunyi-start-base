package com.lishunyi.config;

import com.lishunyi.porperties.DistributedIDPorperties;
import com.lishunyi.segment.service.SegmentIDGenImpl;
import com.lishunyi.snowflake.SnowflakeIDGenImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DistributedIDConfiguration
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/19 16:56
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/19 16:56
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties(value = {DistributedIDPorperties.class})
public class DistributedIDConfiguration {

    @Autowired
    private DistributedIDPorperties porperties;

    @ConditionalOnProperty(prefix = "distributed.id.segment", name = "enable", havingValue = "true", matchIfMissing = false)
    public SegmentIDGenImpl initLeafSegmentStarter() {
        SegmentIDGenImpl segmentIDGen = new SegmentIDGenImpl();
        return segmentIDGen;
    }

    @ConditionalOnProperty(prefix = "distributed.id.snowflake", name = "enable", havingValue = "true", matchIfMissing = false)
    public SnowflakeIDGenImpl initLeafSnowflakeStarter() {
        SnowflakeIDGenImpl snowflakeIDGen = new SnowflakeIDGenImpl(porperties.getSnowflake().getZookeeper().getAddress(), Integer.parseInt(porperties.getSnowflake().getZookeeper().getPort()));
        return snowflakeIDGen;
    }
}
