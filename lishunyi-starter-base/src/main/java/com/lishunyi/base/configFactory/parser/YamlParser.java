package com.lishunyi.base.configFactory.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName YamlParser
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/24 13:57
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/24 13:57
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class YamlParser implements Parser {

    private static final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());

    @Override
    public Map<String, Object> parser(File file) throws IOException {
        LinkedHashMap root = MAPPER.readValue(file, LinkedHashMap.class);
        return null;
    }

    private static Map<String, Object> mapParseRecursive(Map<String, Object> map) {
        Map<String, Object> res = new LinkedHashMap<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Object o = map.get(key);
            if (o instanceof Map) {
                Map tmpMap = (Map) o;
                Map kvMap = mapParseRecursive(tmpMap);
                Set<String> kvKeySet = kvMap.keySet();
                for (String kvKey : kvKeySet) {
                    res.put(key + "." + kvKey, kvMap.get(kvKey));
                }
            } else if (o instanceof List) {
                Map tmpMap = listParseRecursive((List) o);
                Set<String> tmpKeySet = tmpMap.keySet();
                for (String tmpKey : tmpKeySet) {
                    res.put(key + tmpKey, tmpMap.get(tmpKey).toString());
                }
            } else {
                Object value = o;
                res.put(key, value);
            }
        }
        return res;
    }

    private static Map<String, Object> listParseRecursive(List list) {
        Map<String, Object> res = new LinkedHashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            if (o instanceof Map) {
                Map tmpMap = mapParseRecursive((Map) o);
                Set<String> keySet = tmpMap.keySet();
                for (String kvKey : keySet) {
                    res.put("[" + i + "]." + kvKey, tmpMap.get(kvKey).toString());
                }
            } else if (o instanceof List) {
                Map tmpMap = listParseRecursive((List) o);
                Set<String> keySet = tmpMap.keySet();
                for (String key : keySet) {
                    res.put("[" + i + "]" + key, tmpMap.get(key).toString());
                }
            } else if (o != null) {
                res.put("[" + i + "]", o.toString());
            }
        }
        return res;
    }
}
