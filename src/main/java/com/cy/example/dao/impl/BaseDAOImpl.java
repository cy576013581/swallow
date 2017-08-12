/*package com.cy.example.dao.impl;

import java.io.Serializable; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 

import org.apache.commons.lang.StringUtils; 
import org.apache.ibatis.session.ResultHandler; 
import org.apache.ibatis.session.RowBounds; 
import org.mybatis.spring.support.SqlSessionDaoSupport; 

import util.bean.BeanMapUtil; 
import util.dao.IBaseGenericDAO; 
import util.exception.BaseDaoException; 
import util.page.GenericDefaultPage; 
import util.page.IGenericPage; 
import util.reflect.ReflectGeneric; 
*//** 
* 基于Mybatis的基础泛型DAO实现类。 

* 
* @param <T> 业务实体类型 
* @param <ID> ID类型 ，如：String、Long、Integer 等 
*//* 
public abstract class BaseDAOImpl<T, ID extends Serializable> 
extends SqlSessionDaoSupport 
implements IBaseGenericDAO<T, ID> { 

public static final String SQLNAME_SEPARATOR = "."; 

public static final String SQL_SAVE = "save";   
public static final String SQL_UPDATE = "update";   
public static final String SQL_GETBYID = "getById"; 
public static final String SQL_DELETEBYID = "deleteById"; 
public static final String SQL_DELETEBYIDS = "deleteByIds"; 
public static final String SQL_FINDPAGEBY = "findPageBy";   
public static final String SQL_FINDLISTBY = "findListBy"; 
public static final String SQL_GETCOUNTBY = "getCountBy"; 

private static final String SORT_NAME = "SORT"; 

private static final String DIR_NAME = "DIR"; 
*//** 不能用于SQL中的非法字符（主要用于排序字段名） *//* 
public static final String[] ILLEGAL_CHARS_FOR_SQL = {",", ";", " ", "\"", "%"}; 

*//** 
* 获取默认SqlMapping命名空间。 
* 使用泛型参数中业务实体类型的全限定名作为默认的命名空间。 
* 如果实际应用中需要特殊的命名空间，可由子类重写该方法实现自己的命名空间规则。 
* @return 返回命名空间字符串 
*//* 
@SuppressWarnings("unchecked") 
protected String getDefaultSqlNamespace() { 
Class<T> clazz = ReflectGeneric.getClassGenricType(this.getClass()); 
String nameSpace = clazz.getName(); 
return nameSpace; 
} 

*//** 
* 将SqlMapping命名空间与给定的SqlMapping名组合在一起。 
* @param sqlName SqlMapping名 
* @return 组合了SqlMapping命名空间后的完整SqlMapping名 
*//* 
protected String getSqlName(String sqlName) { 
return sqlNamespace + SQLNAME_SEPARATOR + sqlName; 
} 

*//** 
* SqlMapping命名空间 
*//* 
private String sqlNamespace = getDefaultSqlNamespace(); 

*//** 
* 获取SqlMapping命名空间 
* @return SqlMapping命名空间 
*//* 
public String getSqlNamespace() { 
return sqlNamespace; 
} 

*//** 
* 设置SqlMapping命名空间。 
* 此方法只用于注入SqlMapping命名空间，以改变默认的SqlMapping命名空间， 
* 不能滥用此方法随意改变SqlMapping命名空间。 
* @param sqlNamespace SqlMapping命名空间 
*//* 
public void setSqlNamespace(String sqlNamespace) { 
this.sqlNamespace = sqlNamespace; 
} 

*//** 
* 生成主键值。 
* 默认情况下什么也不做； 
* 如果需要生成主键，需要由子类重写此方法根据需要的方式生成主键值。 
* @param ob 要持久化的对象 
*//* 
protected void generateId(T ob) { 

} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#save(java.lang.Object) 
 
public Integer save(T ob) { 
generateId(ob); 
return this.getSqlSession().insert( 
getSqlName(SQL_SAVE), ob); 
} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#update(java.lang.Object) 
 
public Integer update(T ob) { 
return this.getSqlSession().update( 
getSqlName(SQL_UPDATE), ob); 
} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#getById(java.lang.String) 
 
@SuppressWarnings("unchecked") 
public T getById(String id) { 
return (T) this.getSqlSession().selectOne( 
getSqlName(SQL_GETBYID), id); 
} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#deleteByIds(ID[]) 
 
public Integer deleteByIds(ID[] ids) { 
return this.getSqlSession().delete( 
getSqlName(SQL_DELETEBYIDS), ids); 
} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#deleteById(java.io.Serializable) 
 
public Integer deleteById(ID id){ 
return this.getSqlSession().delete( 
getSqlName(SQL_DELETEBYID), id); 
} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#findPageBy(java.lang.Object, int, int, java.lang.String, java.lang.String) 
 
@SuppressWarnings("unchecked") 
public IGenericPage<T> findPageBy( 
T param, int pageNo, int pageSize, String sort, String dir) { 

// 获取满足条件的记录总数，没有记录时返回空页数据 
int count = getCountBy(param); 
if (count < 1) { 
return GenericDefaultPage.emptyPage(); 
} 

Map<String, Object> paramMap = null; 
try{ 
paramMap = BeanMapUtil.bean2Map(param); 
}catch(Exception e){ 
throw new BaseDaoException("获取参数失败", e); 
} 
// Where过滤条件 
//	paramMap.put("param", param); 
// 排序条件 
if (sort != null) { 
// 排序字段不为空，过滤其中可能存在的非法字符 
sort = filterIllegalChars(sort, ILLEGAL_CHARS_FOR_SQL); 
} 
if (StringUtils.isEmpty(sort) || StringUtils.isEmpty(dir)) { 
//	paramMap.put("sort", null); 
//	paramMap.put("dir", null); 
} else { 
paramMap.put(SORT_NAME, sort); 
paramMap.put(DIR_NAME, dir); 
} 
// 分页条件 
int start = GenericDefaultPage.getStartOfPage( 
pageNo, pageSize) - 1; 
RowBounds rowBound = new RowBounds(start, pageSize); 

List<T> lst = this.getSqlSession().selectList( 
getSqlName(SQL_FINDPAGEBY), 
paramMap, rowBound); 

return new GenericDefaultPage<T>(pageNo, pageSize, lst, count); 
} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#getCountBy(java.lang.Object) 
 
public Integer getCountBy(T param) { 
Map<String, Object> paramMap = null; 
try{ 
paramMap = BeanMapUtil.bean2Map(param); 
}catch(Exception e){ 
throw new BaseDaoException("获取参数失败", e); 
} 
//	paramMap.put("param", param); 
return (Integer)this.getSqlSession().selectOne( 
getSqlName(SQL_GETCOUNTBY), paramMap); 
} 

 (non-Javadoc) 
* @see com.harmony.framework.dao.mybatis.IBaseGenericDAO#findListBy(java.lang.Object, java.lang.String, java.lang.String) 
 
@SuppressWarnings("unchecked") 
public List<T> findListBy(T param, String sort, String dir) { 
Map<String, Object> paramMap = null; 
try{ 
paramMap = BeanMapUtil.bean2Map(param); 
}catch(Exception e){ 
throw new BaseDaoException("获取参数失败", e); 
} 
// Where过滤条件 
//	paramMap.put("param", param); 
// 排序条件 
if (sort != null) { 
// 排序字段不为空，过滤其中可能存在的非法字符 
sort = filterIllegalChars(sort, ILLEGAL_CHARS_FOR_SQL); 
} 
if (StringUtils.isEmpty(sort) || StringUtils.isEmpty(dir)) { 
//	paramMap.put("sort", null); 
//	paramMap.put("dir", null); 
} else { 
paramMap.put(SORT_NAME, sort); 
paramMap.put(DIR_NAME, dir); 
} 
List<T> lst = this.getSqlSession().selectList( 
getSqlName(SQL_FINDLISTBY), paramMap); 
return lst; 
} 

public List<T> findListBy(T param){ 
return findListBy(param, null, null); 
} 
*//** 
* 从给定字符串中将指定的非法字符串数组中各字符串过滤掉。 
* @param str 待过滤的字符串 
* @param filterChars 指定的非法字符串数组 
* @return 过滤后的字符串 
*//* 
protected String filterIllegalChars(String str, String[] filterChars) { 
String rs = str; 
if (rs != null && filterChars != null) { 
for (String fc : filterChars) { 
if (fc != null && fc.length() > 0) { 
str = str.replaceAll(fc, ""); 
} 
} 
} 
return rs; 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#insert(java.lang.String, java.lang.Object)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @return 执行结果——插入成功的记录数 
* @see org.apache.ibatis.session.SqlSession#insert(java.lang.String, java.lang.Object) 
*//* 
protected int insert(String statement, Object parameter) { 
return this.getSqlSession().insert( 
getSqlName(statement), parameter); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#insert(java.lang.String)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @return 执行结果——插入成功的记录数 
* @see org.apache.ibatis.session.SqlSession#insert(java.lang.String) 
*//* 
protected int insert(String statement) { 
return this.getSqlSession().insert( 
getSqlName(statement)); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#update(java.lang.String, java.lang.Object)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @return 执行结果——更新成功的记录数 
* @see org.apache.ibatis.session.SqlSession#update(java.lang.String, java.lang.Object) 
*//* 
protected int update(String statement, Object parameter) { 
return this.getSqlSession().update( 
getSqlName(statement), parameter); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#update(java.lang.String)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @return 执行结果——更新成功的记录数 
* @see org.apache.ibatis.session.SqlSession#update(java.lang.String) 
*//* 
protected int update(String statement) { 
return this.getSqlSession().update( 
getSqlName(statement)); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#delete(java.lang.String, java.lang.Object)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @return 执行结果——删除成功的记录数 
* @see org.apache.ibatis.session.SqlSession#delete(java.lang.String, java.lang.Object) 
*//* 
protected int delete(String statement, Object parameter) { 
return this.getSqlSession().delete( 
getSqlName(statement), parameter); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#delete(java.lang.String)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @return 执行结果——删除成功的记录数 
* @see org.apache.ibatis.session.SqlSession#delete(java.lang.String) 
*//* 
protected int delete(String statement) { 
return this.getSqlSession().delete( 
getSqlName(statement)); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectList(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @param rowBounds 用于分页查询的记录范围 
* @return 查询结果列表 
* @see org.apache.ibatis.session.SqlSession#selectList(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds) 
*//* 
protected List selectList( 
String statement, Object parameter, RowBounds rowBounds) { 
return this.getSqlSession().selectList( 
getSqlName(statement), parameter, rowBounds); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectList(java.lang.String, java.lang.Object)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @return 查询结果列表 
* @see org.apache.ibatis.session.SqlSession#selectList(java.lang.String, java.lang.Object) 
*//* 
protected List selectList(String statement, Object parameter) { 
return this.getSqlSession().selectList( 
getSqlName(statement), parameter); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectList(java.lang.String)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @return 查询结果列表 
* @see org.apache.ibatis.session.SqlSession#selectList(java.lang.String) 
*//* 
protected List selectList(String statement) { 
return this.getSqlSession().selectList( 
getSqlName(statement)); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectOne(java.lang.String, java.lang.Object)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @return 查询结果对象 
* @see org.apache.ibatis.session.SqlSession#selectOne(java.lang.String, java.lang.Object) 
*//* 
protected Object selectOne(String statement, Object parameter) { 
return this.getSqlSession().selectOne( 
getSqlName(statement), parameter); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectOne(java.lang.String)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @return 查询结果对象 
* @see org.apache.ibatis.session.SqlSession#selectOne(java.lang.String) 
*//* 
protected Object selectOne(String statement) { 
return this.getSqlSession().selectOne( 
getSqlName(statement)); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.Object, java.lang.String, org.apache.ibatis.session.RowBounds)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @param mapKey 数据mapKey 
* @param rowBounds 用于分页查询的记录范围 
* @return 查询结果Map 
* @see org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.Object, java.lang.String, org.apache.ibatis.session.RowBounds) 
*//* 
protected Map selectMap( 
String statement, Object parameter, String mapKey, 
RowBounds rowBounds) { 
return this.getSqlSession().selectMap( 
getSqlName(statement), 
parameter, mapKey, rowBounds); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.Object, java.lang.String)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @param mapKey 数据mapKey 
* @return 查询结果Map 
* @see org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.Object, java.lang.String) 
*//* 
protected Map selectMap( 
String statement, Object parameter, String mapKey) { 
return this.getSqlSession().selectMap( 
getSqlName(statement), parameter, mapKey); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.String)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param mapKey 数据mapKey 
* @return 查询结果Map 
* @see org.apache.ibatis.session.SqlSession#selectMap(java.lang.String, java.lang.String) 
*//* 
protected Map selectMap(String statement, String mapKey) { 
return this.getSqlSession().selectMap( 
getSqlName(statement), mapKey); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds, org.apache.ibatis.session.ResultHandler)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @param rowBounds 用于分页查询的记录范围 
* @param handler 结果集处理器 
* @see org.apache.ibatis.session.SqlSession#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.RowBounds, org.apache.ibatis.session.ResultHandler) 
*//* 
protected void select( 
String statement, Object parameter, RowBounds rowBounds, 
ResultHandler handler) { 
this.getSqlSession().select( 
getSqlName(statement), 
parameter, rowBounds, handler); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.ResultHandler)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param parameter 参数 
* @param handler 结果集处理器 
* @see org.apache.ibatis.session.SqlSession#select(java.lang.String, java.lang.Object, org.apache.ibatis.session.ResultHandler) 
*//* 
protected void select( 
String statement, Object parameter, ResultHandler handler) { 
this.getSqlSession().select( 
getSqlName(statement), parameter, handler); 
} 

*//** 
* 对{@link org.apache.ibatis.session.SqlSession#select(java.lang.String, org.apache.ibatis.session.ResultHandler)}的代理。 
* 将statement包装了命名空间，方便DAO子类调用。 
* @param statement 映射的语句ID 
* @param handler 结果集处理器 
* @see org.apache.ibatis.session.SqlSession#select(java.lang.String, org.apache.ibatis.session.ResultHandler) 
*//* 
protected void select(String statement, ResultHandler handler) { 
this.getSqlSession().select( 
getSqlName(statement), handler); 
} 

//	protected Integer update(String sqlName, Object param){ 
//	return this.getSqlSession().update(sqlNamespace+"."+sqlName, param); 
//	} 
//	protected Integer save(String sqlName, Object param){ 
//	return this.getSqlSession().insert(sqlNamespace+"."+sqlName, param); 
//	} 
//	protected Integer delete(String sqlName, Object param){ 
//	return this.getSqlSession().delete(sqlNamespace+"."+sqlName, param); 
//	} 
//	protected Integer delete(String sqlName, Object[] param){ 
//	return this.getSqlSession().delete(sqlNamespace+"."+sqlName, param); 
//	} 
//	protected List<Object> getMap(String sqlName, Object param){ 
//	Map paramMap = new HashMap(); 
//	paramMap.put("param", param); 
//	return this.getSqlSession().selectList(sqlNamespace+"."+sqlName, paramMap); 
//	} 
//	protected List<Object> getMap(String sqlName, Map param){ 
//	return this.getSqlSession().selectList(sqlNamespace+"."+sqlName, param); 
//	} 
//	protected List findPageBy(String sqlName, Object param,int pageNo, int pageSize,String sort,String dir){ 
//	Map paramMap = new HashMap(); 
//	paramMap.put("param", param); 
//	if (StringUtils.isEmpty(sort) || StringUtils.isEmpty(dir)) 
//	{ 
//	paramMap.put("sort", null); 
//	paramMap.put("dir", null); 
//	} 
//	int start =0; 
//	if (pageNo > -1) 
//	start = (pageNo - 1) * pageSize; 
//	RowBounds rowBound = new RowBounds(start,pageSize); 
//	List lst = this.getSqlSession().selectList(sqlNamespace+"."+sqlName, paramMap,rowBound); 
//	return lst; 
//	} 
//	
//	protected Integer getCountBy(String sqlName, Object param){ 
//	Map paramMap = new HashMap(); 
//	paramMap.put("param", param); 
//	return (Integer)this.getSqlSession().selectOne(sqlNamespace+"."+sqlName, paramMap); 
//	} 
//	protected Object getBy(String sqlName, String id){ 
//	return this.getSqlSession().selectOne(sqlNamespace+"."+sqlName, id); 
//	} 
//	protected List getListBy(String sqlName,String id) { 
//	return this.getSqlSession().selectList(sqlNamespace+"."+sqlName, id); 
//	} 
//	protected List findListBy(String sqlName,Object[] params) { 
//	return this.getSqlSession().selectList(sqlNamespace+"."+sqlName, params); 
//	} 
//	protected Object getBy(String sqlName,Object param) { 
//	return this.getSqlSession().selectOne(sqlNamespace+"."+sqlName, param); 
//	} 
//	protected List findByParam(String sqlName,Object param) { 
//	return this.getSqlSession().selectList(sqlNamespace+"."+sqlName, param); 
//	} 
} */