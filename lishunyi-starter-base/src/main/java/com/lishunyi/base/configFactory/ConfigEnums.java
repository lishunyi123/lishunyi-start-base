package com.lishunyi.base.configFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * @EnumName ConfigEnums
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/23 16:45
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/23 16:45
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@AllArgsConstructor
public enum ConfigEnums {

    PROPERTIES("properties"),
    YML("yml"),
    YAML("yaml");

    @Getter
    private String value;

    public static ConfigEnums valuesOf(String value) {

        ConfigEnums configEnums = resolve(value);
        if (configEnums == null) {
            throw new IllegalArgumentException("没有与 [" + value + "] 匹配的");
        } else {
            return configEnums;
        }
    }

    @Nullable
    public static ConfigEnums resolve(String value) {

        ConfigEnums[] values = values();
        for (ConfigEnums configEnums : values) {
            if (configEnums.getValue().equals(value)) {
                return configEnums;
            }
        }
        return null;
    }
}
