package com.lishunyi.base.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Optional;

/**
 * @ClassName Response
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/11/13 10:15
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/11/13 10:15
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Data
@ApiModel(description = "统一消息返回体")
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -6879975066183253637L;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "响应消息")
    private String msg;

    @ApiModelProperty(value = "响应状态")
    private Boolean status;

    @ApiModelProperty(value = "服务器时间戳")
    private Long currentTime;

    @ApiModelProperty(value = "返回对象")
    private T data;

    private Response(ResponseCode responseCode, String msg, T data) {
        this.code = responseCode.getCode();
        this.msg = msg;
        this.status = ResponseCode.OK == responseCode;
        this.currentTime = System.currentTimeMillis();
        this.data = data;
    }

    private Response(ResponseCode responseCode) {
        this(responseCode, responseCode.getMsg(), null);
    }

    private Response(ResponseCode responseCode, String msg) {
        this(responseCode, msg, null);
    }

    private Response(ResponseCode responseCode, T data) {
        this(responseCode, responseCode.getMsg(), data);
    }

    /**
     * 判断是否成功
     *
     * @param response 响应结果
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable Response<?> response) {
        return Optional.ofNullable(response)
                .map(r -> r.code)
                .map(code -> ResponseCode.OK.getCode() == code)
                .orElse(Boolean.FALSE);
    }

    /**
     * 判断是否失败
     *
     * @param response 响应结果
     * @return 是否失败
     */
    public static boolean isError(@Nullable Response<?> response) {
        return !isSuccess(response);
    }

    /**
     * 获取data
     *
     * @param response 响应结果
     * @param <T>      泛型
     * @return data对象
     */
    public static <T> T getData(@Nullable Response<T> response) {
        return Optional.ofNullable(response)
                .filter(r -> r.status)
                .map(x -> x.data)
                .orElse(null);
    }

    /**
     * 返回不带数据的成功
     *
     * @param <T> 泛型
     * @return Response
     */
    public static <T> Response<T> success() {
        return new Response<>(ResponseCode.OK);
    }

    /**
     * 返回携带数据的成功
     *
     * @param data 数据
     * @param <T>  泛型
     * @return Response
     */
    public static <T> Response<T> success(@Nullable T data) {
        return new Response<>(ResponseCode.OK, data);
    }

    /**
     * 返回失败信息
     *
     * @param msg 失败信息
     * @param <T> 泛型
     * @return Response
     */
    public static <T> Response<T> error(String msg) {
        return new Response<>(ResponseCode.INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * 返回失败信息
     *
     * @param responseCode 枚举类型
     * @param <T>          泛型
     * @return Response
     */
    public static <T> Response<T> error(ResponseCode responseCode) {
        return new Response<>(responseCode);
    }

    /**
     * 返回失败信息
     *
     * @param responseCode 枚举类型
     * @param msg          失败信息
     * @param <T>          泛型
     * @return Response
     */
    public static <T> Response<T> error(ResponseCode responseCode, String msg) {
        return new Response<>(responseCode, msg);
    }

    /**
     * 根据状态返回成功或者失败
     *
     * @param status 状态
     * @param msg    失败信息
     * @param <T>    泛型
     * @return Response
     */
    public static <T> Response<T> status(boolean status, String msg) {
        return status ? Response.success() : Response.error(msg);
    }

    /**
     * 根据状态返回成功或者失败
     *
     * @param status       状态
     * @param responseCode 异常code
     * @param <T>          泛型
     * @return Response
     */
    public static <T> Response<T> status(boolean status, ResponseCode responseCode) {
        return status ? Response.success() : Response.error(responseCode);
    }
}
