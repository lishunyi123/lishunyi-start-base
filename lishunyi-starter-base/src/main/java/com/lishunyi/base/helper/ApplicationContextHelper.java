package com.lishunyi.base.helper;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApplicationContextHelper
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/10/23 11:34
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/23 11:34
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    @Getter
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
