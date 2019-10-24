package com.lishunyi.base.configFactory.parser;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @InterfaceName Parser
 * @Description 解析器
 * @Author 李顺仪
 * @CreateDate 2019/10/24 13:56
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/24 13:56
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface Parser {

    Map<String, Object> parser(File file) throws IOException;

}
