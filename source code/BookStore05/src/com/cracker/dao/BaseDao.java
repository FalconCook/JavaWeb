package com.cracker.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cracker.utils.JDBCUtils;


public class BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner();
	//需要获取实际的type
	private Class<T> type;
	
	public BaseDao() {
		//获取父类的类型，父类是带参数的
		ParameterizedType superclass = (ParameterizedType)this.getClass().getGenericSuperclass();
		System.out.println(superclass.getClass());
		//获取参数的类型
		type = (Class<T>) superclass.getActualTypeArguments()[0];
		
	}
	
	/**
	 * 查询一个对象
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql , Object... params){
		T query = null;
		
		//获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		
		try {
			query = runner.query(conn, sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.releaseConnection(conn);
		}
		
		return query;
	}
	
	/**
	 * 获取对象的集合
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql , Object ... params){
		
		List<T> query = null;
		
		//获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		
		try {
			query = runner.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.releaseConnection(conn);
		}
		return query;
		
	}
	
	
	/**
	 * 更新数据库操作的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql , Object ... params){
		int count = 0;
		
		Connection conn = JDBCUtils.getConnection();
		try {
			count = runner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.releaseConnection(conn);
		}
		return count;
	}
	
	/**
	 * 查询单个值
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getSingleValue(String sql , Object ... params) {
		Object query = null;
		Connection conn = JDBCUtils.getConnection();
		try {
			query = runner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.releaseConnection(conn);
		}
		return query;
	}

}
