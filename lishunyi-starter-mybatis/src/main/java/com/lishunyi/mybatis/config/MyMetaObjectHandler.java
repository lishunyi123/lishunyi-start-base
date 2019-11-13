package com.lishunyi.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ClassName MyMetaObjectHandler
 * @Description 自动填充字段处理
 * @Author 李顺仪
 * @CreateDate 2019/10/31 11:07
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/10/31 11:07
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
	}
}
