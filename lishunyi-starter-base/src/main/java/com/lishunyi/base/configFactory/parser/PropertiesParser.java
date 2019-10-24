package com.lishunyi.base.configFactory.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName PropertiesParser
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/24 14:25
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/24 14:25
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class PropertiesParser implements Parser {

    @Override
    public Map<String, Object> parser(File file) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        Map<String, Object> map = new LinkedHashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put((String) entry.getKey(), entry.getValue());
        }
        return map;
    }

}
