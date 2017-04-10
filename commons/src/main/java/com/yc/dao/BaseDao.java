package com.yc.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	public List<T> find(Map map);	//条件查询，可以为null
	public T get(Serializable id);	//单个查询
	public void deleteById(Serializable id);
	public void delete(Serializable[] ids);
	public void update(T entity);
	public void insert(T entity);

}
