package com.lishunyi.base.configFactory.parser;

import com.lishunyi.base.configFactory.ConfigEnums;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @ClassName ParserFactory
 * @Description 解析器工厂类
 * @Author 李顺仪
 * @CreateDate 2019/10/24 14:29
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/24 14:29
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class ParserFactory {

    private static final Map<ConfigEnums, Supplier<Parser>> parserFactorys = new EnumMap<>(ConfigEnums.class);

    static {
        parserFactorys.put(ConfigEnums.YAML, YamlParser::new);
        parserFactorys.put(ConfigEnums.YML, YamlParser::new);
        parserFactorys.put(ConfigEnums.PROPERTIES, PropertiesParser::new);
    }

    public static Parser getParser(ConfigEnums configEnums) {
        return Optional.ofNullable(parserFactorys.get(configEnums))
                .map(Supplier::get)
                .orElseThrow(() -> new IllegalArgumentException("当前仅支持yml与proprerties文件"));
    }
}
