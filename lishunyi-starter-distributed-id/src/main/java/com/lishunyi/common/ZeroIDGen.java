package com.lishunyi.common;

/**
 * @ClassName ZeroIDGen
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/18 11:37
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/18 11:37
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public class ZeroIDGen implements IDGen {

    @Override
    public Long get(String key) {
        return 0L;
    }
}
