package com.lishunyi.common;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName PropertyFactory
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/22 14:33
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/22 14:33
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Slf4j
public class PropertyFactory {
	private static final Yaml yaml = new Yaml();
	private static final Map map = new HashMap(16);

	static {
		try {
			InputStream resourceAsStream = null;
			if (null != PropertyFactory.class.getClassLoader().getResourceAsStream("bootstrap.yml")) {
				resourceAsStream = PropertyFactory.class.getClassLoader().getResourceAsStream("bootstrap.yml");
			} else if (null != PropertyFactory.class.getClassLoader().getResourceAsStream("bootstrap.properties")) {
				resourceAsStream = PropertyFactory.class.getClassLoader().getResourceAsStream("bootstrap.properties");
			} else if (null != PropertyFactory.class.getClassLoader().getResourceAsStream("application.yml")) {
				resourceAsStream = PropertyFactory.class.getClassLoader().getResourceAsStream("application.yml");
			} else if (null != PropertyFactory.class.getClassLoader().getResourceAsStream("application.properties")) {
				resourceAsStream = PropertyFactory.class.getClassLoader().getResourceAsStream("application.properties");
			}
			Map map = yaml.loadAs(resourceAsStream, Map.class);
		} catch (Exception e) {
			log.warn("Load Properties Ex", e);
		}
	}

	public static Map getProperties() {
		return map;
	}
}
