package com.lishunyi.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lishunyi.base.id.IdConfig;
import com.lishunyi.mybatis.entity.BaseEntity;
import com.lishunyi.mybatis.entity.BaseTenantEntity;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

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
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity<T>> extends ServiceImpl<M, T> implements IService<T> {
	protected Log log = LogFactory.getLog(this.getClass());
	@Autowired(required = false)
	protected M baseMapper;

	@Value("${spring.application.name:default}")
	private String applicationName;

	@Autowired
	protected IdConfig idConfig;

	@Autowired
	protected RedisTemplate<String, Object> redisTemplate;

	private Long tenantId;

	private void initId(T entity) {
		if (entity instanceof BaseTenantEntity) {
			// TODO ID发号中心赋值
			entity.setId(1L);
		} else {
			entity.setId(idConfig.snowflake().nextId());
		}
	}

	@Override
	public boolean save(T entity) {
		this.initId(entity);
		return super.save(entity);
	}

	@Override
	public boolean saveBatch(Collection<T> entityList, int batchSize) {
		if (!CollectionUtils.isEmpty(entityList)) {
			entityList.forEach(this::initId);
		}
		return super.saveBatch(entityList, batchSize);
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
	@CacheEvict(value = "cache", key = "#root.targetClass.simpleName + ':' + #id")
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
		redisTemplate.delete((Collection<String>) idList);
		return false;
	}

	@Override
	@CacheEvict(value = "cache", key = "#root.targetClass.simpleName + ':' + #entity.id")
	public boolean updateById(T entity) {
		return super.updateById(entity);
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
		if (Objects.isNull(entity)) {
			return false;
		}
		if (Objects.isNull(entity.getId())) {
			return this.save(entity);
		}
		return this.updateById(entity);
	}

	@Override
	@Cacheable(value = "cache", key = "#root.targetClass.simpleName + ':' + #id")
	public T getById(Serializable id) {
		return super.getById(id);
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
