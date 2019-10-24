package com.lishunyi.base.configFactory.build;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PropertiesBuilder
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/24 13:24
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/24 13:24
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class PropertiesBuilder implements Builder {

    @Override
    public String build(Map<String, Object> kv) {
        StringBuilder res = new StringBuilder();
        List<String> keyList = new ArrayList<>(kv.keySet());
        Collections.sort(keyList);
        for (String key : keyList) {
            res.append(key);
            res.append("=");
            res.append(kv.getOrDefault(key, ""));
            res.append("\n");
        }
        return res.toString();
    }
}
