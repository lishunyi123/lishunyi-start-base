package com.lishunyi.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.lishunyi.base.constant.BaseConstants;
import com.lishunyi.mybatis.entity.BaseEntity;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author 李顺仪
 * @version 1.0
 * @since 2020/10/26 16:56
 **/
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity<T>> implements IService<T>, InitializingBean {
	protected Log log = LogFactory.getLog(this.getClass());
	@Autowired
	protected M baseMapper;

	@Value("${spring.application.name:default}")
	private String applicationName;

	private Long tenantId;

	private String cacheKeyPrefix;


	@Override
	public void afterPropertiesSet() throws Exception {
		if (Objects.isNull(tenantId)) {
			tenantId = 0L;
		}
		this.cacheKeyPrefix = this.applicationName + BaseConstants.COLON + tenantId + BaseConstants.COLON + this.getClass().getName() + BaseConstants.COLON;
	}

	@Override
	public boolean save(T entity) {
		return SqlHelper.retBool(this.getBaseMapper().insert(entity));
	}

	@Override
	public boolean saveBatch(Collection<T> entityList) {
		return false;
	}

	@Override
	public boolean saveBatch(Collection<T> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<T> entityList) {
		return false;
	}

	@Override
	public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean removeById(Serializable id) {
		return false;
	}

	@Override
	public boolean removeByMap(Map<String, Object> columnMap) {
		return false;
	}

	@Override
	public boolean remove(Wrapper<T> queryWrapper) {
		return false;
	}

	@Override
	public boolean removeByIds(Collection<? extends Serializable> idList) {
		return false;
	}

	@Override
	@CachePut(value = "entity", key = "#entity.id")
	public boolean updateById(T entity) {
		return false;
	}

	@Override
	public boolean update(Wrapper<T> updateWrapper) {
		return false;
	}

	@Override
	public boolean update(T entity, Wrapper<T> updateWrapper) {
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<T> entityList) {
		return false;
	}

	@Override
	public boolean updateBatchById(Collection<T> entityList, int batchSize) {
		return false;
	}

	@Override
	public boolean saveOrUpdate(T entity) {
		return false;
	}

	@Override
	public T getById(Serializable id) {
		return null;
	}

	@Override
	public List<T> listByIds(Collection<? extends Serializable> idList) {
		return null;
	}

	@Override
	public List<T> listByMap(Map<String, Object> columnMap) {
		return null;
	}

	@Override
	public T getOne(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
		return null;
	}

	@Override
	public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public int count(Wrapper<T> queryWrapper) {
		return 0;
	}

	@Override
	public List<T> list(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public List<T> list() {
		return null;
	}

	@Override
	public <E extends IPage<T>> E page(E page, Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public <E extends IPage<T>> E page(E page) {
		return null;
	}

	@Override
	public List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public List<Map<String, Object>> listMaps() {
		return null;
	}

	@Override
	public List<Object> listObjs() {
		return null;
	}

	@Override
	public <V> List<V> listObjs(Function<? super Object, V> mapper) {
		return null;
	}

	@Override
	public List<Object> listObjs(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public <V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
		return null;
	}

	@Override
	public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
		return null;
	}

	@Override
	public BaseMapper<T> getBaseMapper() {
		return null;
	}

	@Override
	public QueryChainWrapper<T> query() {
		return null;
	}

	@Override
	public LambdaQueryChainWrapper<T> lambdaQuery() {
		return null;
	}

	@Override
	public UpdateChainWrapper<T> update() {
		return null;
	}

	@Override
	public LambdaUpdateChainWrapper<T> lambdaUpdate() {
		return null;
	}

	@Override
	public boolean saveOrUpdate(T entity, Wrapper<T> updateWrapper) {
		return false;
	}

}
