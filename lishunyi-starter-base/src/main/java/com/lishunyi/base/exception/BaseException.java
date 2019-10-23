package com.lishunyi.base.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName BaseException
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/22 18:00
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/22 18:00
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseException extends Exception implements IBaseException {

    private String code;

    private String description;

    private Object[] parameters;

    public BaseException(String code, String description, Object... parameters) {
        super(description);
        this.code = code;
        this.description = description;
        this.parameters = parameters;
    }
}
