package com.lishunyi.base.http;

//import com.sun.istack.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @EnumName HttpStatus
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/12 14:24
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/12 14:24
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum HttpStatus {
    OK(200, "操作成功"),
    BAD_REQUEST(400, "错误的请求"),
    UNAUTHORIZED(401, "您没有权限"),
    NOT_FOUND(404, "找不到地址"),
    METHOD_NOT_ALLOWED(405, "请求方式错误"),
    REQUEST_TIMEOUT(408, "请求超时"),
    URI_TOO_LONG(414, "uri超长"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_GATEWAY(502, "无效网关"),
    SERVICE_UNAVAILABLE(503, "服务暂停"),
    GATEWAY_TIMEOUT(505, "网关超时");

    private int code;

    private String msg;

    public static HttpStatus valueOf(int statusCode) {
        HttpStatus status = resolve(statusCode);
        if (status == null) {
            throw new IllegalArgumentException("没有与 [" + statusCode + "] 匹配的");
        } else {
            return status;
        }
    }

//    @Nullable
    public static HttpStatus resolve(int statusCode) {
        HttpStatus[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            HttpStatus status = var1[var3];
            if (status.code == statusCode) {
                return status;
            }
        }

        return null;
    }
}
