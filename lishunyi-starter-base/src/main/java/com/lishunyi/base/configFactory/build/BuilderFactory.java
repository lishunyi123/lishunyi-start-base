package com.lishunyi.base.configFactory.build;

import com.lishunyi.base.configFactory.ConfigEnums;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @ClassName BuilderFactory
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/23 18:04
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/23 18:04
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class BuilderFactory {

    private static Map<ConfigEnums, Supplier<Builder>> builderFactorys = new EnumMap<>(ConfigEnums.class);

    static {
        builderFactorys.put(ConfigEnums.YAML, YamlBuilder::new);
        builderFactorys.put(ConfigEnums.YML, YamlBuilder::new);
        builderFactorys.put(ConfigEnums.PROPERTIES, PropertiesBuilder::new);
    }

    public static Builder getBuilder(ConfigEnums configEnums) {
        return Optional.ofNullable(builderFactorys.get(configEnums))
                .map(Supplier::get)
                .orElseThrow(() -> new IllegalArgumentException("当前仅支持yml、proprerties文件"));
    }
}
