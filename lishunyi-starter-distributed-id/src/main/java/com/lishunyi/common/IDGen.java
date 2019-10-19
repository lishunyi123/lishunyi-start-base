package com.lishunyi.common;

/**
 * @InterfaceName IDGen
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/17 17:00
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/17 17:00
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface IDGen {

    Long get(String key);

    boolean init();
}
