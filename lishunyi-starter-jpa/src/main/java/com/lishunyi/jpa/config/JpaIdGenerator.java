package com.lishunyi.jpa.config;

import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * ID生成策略
 *
 * @author 李顺仪
 * @version 1.0
 * @since 2021/3/17 13:17
 **/
public class JpaIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
		return IdUtil.getSnowflake(1, 1).nextId();
	}
}
