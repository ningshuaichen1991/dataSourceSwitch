package com.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	public int insert(T entity);
	
	public int insertSelective(T entity);
	
	public int deleteByPrimaryKey(Serializable entityid);
	
	public int updateByPrimaryKey(T entity);
	
	public int updateByPrimaryKeySelective(T entity);
	
	public T selectByPrimaryKey(Serializable entityid);
	
	public int selectTotalCount(Map<String, Object> params);
	
	public List<Map<String,Object>> selectMapList(Map<String, Object> params);
	
	public List<T> selectObjectList(Map<String, Object> params);
	
	public List<T> selectAllObjPage(Map<String, Object> param);
	
	public List<T> selectObjectList(T t);
	
	public List<Map<String,Object>> selectAllMapPage(Map<String, Object> param);
}
