package com.lishunyi.base.exception;

/**
 * @InterfaceName IBaseException
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/22 17:52
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/22 17:52
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
public interface IBaseException {

    String getCode();

    String getDescription();

    Object[] getParameters();

    void setCode(String code);

    void setDescription(String description);

    void setParameters(Object[] parameters);
}
