package com.lishunyi.base.configFactory.build;

import io.codearte.props2yaml.Props2YAML;

import java.util.Map;
import java.util.Set;

/**
 * @ClassName YamlBuilder
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/24 13:13
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/24 13:13
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class YamlBuilder implements Builder {

    @Override
    public String build(Map<String, Object> kv) {
        StringBuilder res = new StringBuilder();
        Set<String> keySet = kv.keySet();
        for (String key : keySet) {
            res.append(key);
            res.append("=");
            res.append(kv.getOrDefault(key, ""));
            res.append("\n");
        }
        return Props2YAML.fromContent(res.toString()).convert();
    }
}
