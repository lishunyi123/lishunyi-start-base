package com.lishunyi.base.configFactory.build;

import java.util.Map;

/**
 * @InterfaceName Builder
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/23 16:41
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/23 16:41
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface Builder {

    String build(Map<String, Object> kv);
}
