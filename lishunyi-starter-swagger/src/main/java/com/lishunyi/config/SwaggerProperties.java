package com.lishunyi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName SwaggerProperties
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/12 17:44
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/12 17:44
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String contact;
    private String version = "v1.0";
    private String basePackage;
}
