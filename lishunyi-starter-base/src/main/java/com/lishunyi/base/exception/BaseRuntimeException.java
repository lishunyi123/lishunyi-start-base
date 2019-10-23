package com.lishunyi.base.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName BaseRuntimeException
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/22 18:05
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/22 18:05
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseRuntimeException extends RuntimeException implements IBaseException {

    private String code;

    private String description;

    private Object[] parameters;

    public BaseRuntimeException(String code, String description, Object... parameters) {
        super(description);
        this.code = code;
        this.description = description;
        this.parameters = parameters;
    }

    public BaseRuntimeException(String code, Object... parameters) {
        super(code);
        this.code = code;
        this.description = code;
        this.parameters = parameters;
    }

}
