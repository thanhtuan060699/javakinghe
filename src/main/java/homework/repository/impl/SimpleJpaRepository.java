package homework.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import homework.annotation.Column;
import homework.annotation.Entity;
import homework.annotation.Table;
import homework.mapper.ResultSetMapper;
import homework.paging.Pageable;
import homework.repository.JpaRepository;

public class SimpleJpaRepository<T> implements JpaRepository<T> {
	private Class<T> zClass;
	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		Type type =getClass().getGenericSuperclass();
		ParameterizedType parameterizedType=(ParameterizedType) type;
		zClass=(Class<T>)parameterizedType.getActualTypeArguments()[0];
	}
	@Override
	public List<T> findAll(Map<String,Object> properties,Pageable pageable,Object... where ) {
		String tableName="";
		if(zClass.isAnnotationPresent(Entity.class)&&zClass.isAnnotationPresent(Table.class))
		{
			Table tableClass=zClass.getAnnotation(Table.class);
			tableName=tableClass.name();
		}
		StringBuilder sql=new StringBuilder("select * from "+tableName+" A  where 1=1 ");
		sql=createSQLfindAll(sql,properties);
		if(where!=null&& where.length>0)
		{
			sql.append(where[0]);
		}
		if(pageable.getOffset()!=null&&pageable.getLimit()!=null) {
			sql.append(" limit "+pageable.getOffset()+", "+pageable.getLimit()+"");
		}
		ResultSetMapper<T> resultSetMapper=new ResultSetMapper<>();
		Connection connection = null;
		//PreparedStatement statement = null;
		Statement statement=null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			//statement = connection.prepareStatement(sql.toString());
			statement=connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
		    return resultSetMapper.mapRow(resultSet, this.zClass);
		} catch (SQLException e) {
			return new ArrayList<>();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return new ArrayList<>();
			}
		}
	
	}
	public StringBuilder createSQLfindAll(StringBuilder where,Map<String,Object> params) {
		if(params != null&&params.size()>0)
		{
			String[] keys=new String[params.size()];
			Object[] values = new Object[params.size()];
			int i=0;
			for(Map.Entry<String, Object> item: params.entrySet())
			{
				keys[i]=item.getKey();
				values[i]=item.getValue();
				i++;
			}
			for(int i1=0;i1<keys.length;i1++)
			{
				if((values[i1] instanceof String)&&(StringUtils.isNotBlank(values[i1].toString()))) {
					
					where.append(" and LOWER("+keys[i1]+") like '%"+values[i1].toString()+"%'");
				}else if((values[i1] instanceof Integer)&&(values[i1]!=null)) {
					where.append(" and LOWER("+keys[i1]+") = "+values[i1]+" ");
				}else if((values[i1] instanceof Long)&&(values[i1]!=null)) {
					where.append(" and LOWER("+keys[i1]+") = "+values[i1]+" ");
				}
			}
		}
		return where;
	}
	@Override
	public List<T> findAll(Map<String, Object> properties, Object... where) {
		String tableName="";
		if(zClass.isAnnotationPresent(Entity.class)&&zClass.isAnnotationPresent(Table.class))
		{
			Table tableClass=zClass.getAnnotation(Table.class);
			tableName=tableClass.name();
		}
		StringBuilder sql=new StringBuilder("select * from "+tableName+" A  where 1=1 ");
		sql=createSQLfindAll(sql,properties);
		if(where!=null&& where.length>0)
		{
			sql.append(where[0]);
		}
		ResultSetMapper<T> resultSetMapper=new ResultSetMapper<>();
		Connection connection = null;
		//PreparedStatement statement = null;
		Statement statement=null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			//statement = connection.prepareStatement(sql.toString());
			statement=connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
		    return resultSetMapper.mapRow(resultSet, this.zClass);
		} catch (SQLException e) {
			return new ArrayList<>();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return new ArrayList<>();
			}
		}

	}
	@Override
	public List<T> findAll(String sqlSearch, Pageable pageable, Object... where) {
		StringBuilder sql=new StringBuilder(sqlSearch);
		if(pageable.getOffset()!=null&&pageable.getLimit()!=null) {
			sql.append(" limit "+pageable.getOffset()+", "+pageable.getLimit()+"");
		}
		
		ResultSetMapper<T> resultSetMapper=new ResultSetMapper<>();
		Connection connection = null;
		//PreparedStatement statement = null;
		Statement statement=null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			//statement = connection.prepareStatement(sql.toString());
			statement=connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
		    return resultSetMapper.mapRow(resultSet, this.zClass);
		} catch (SQLException e) {
			return new ArrayList<>();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return new ArrayList<>();
			}
		}
	}
	@Override
	public Long insert(Object object) {
		String sql=createSQLInsert();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id=null;
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			Class<?> aClass=object.getClass();
			Field[] fields=aClass.getDeclaredFields();
			for(int i=0;i<fields.length;i++)
			{
				int index=i+1;
				Field field=fields[i];
				field.setAccessible(true);
				statement.setObject(index, field.get(object));
			}
			Class<?> parentClass=aClass.getSuperclass();
			int indexParent=fields.length+1;
			while(parentClass!=null)
			{
				Field[] fieldsParent=parentClass.getDeclaredFields();
				for(int i=0;i<fieldsParent.length;i++)
				{
					Field field=fieldsParent[i];
					field.setAccessible(true);
					statement.setObject(indexParent, field.get(object));
					indexParent++;
				}
				parentClass=parentClass.getSuperclass();
			}
			statement.executeUpdate();
			//tu id-> Thong tin cua building tu db-> convert data tu resultset->entity
			resultSet=statement.getGeneratedKeys();
			if(resultSet.next())
			{
				id=resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	private String createSQLInsert() {
		String tableName="";
		if(zClass.isAnnotationPresent(Entity.class)&&zClass.isAnnotationPresent(Table.class))
		{
			Table tableClass=zClass.getAnnotation(Table.class);
			tableName=tableClass.name();
		}
		StringBuilder fields=new StringBuilder("");
		StringBuilder params=new StringBuilder("");
		for(Field field:zClass.getDeclaredFields()) {
			if(fields.length()>1) {
				fields.append(",");
				params.append(",");
			}
			if(field.isAnnotationPresent(Column.class)) {
				Column column=field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		Class<?> parentClass=zClass.getSuperclass();
		while(parentClass!=null) {
			for(Field field:parentClass.getDeclaredFields()) {
				if(fields.length()>1) {
					fields.append(",");
					params.append(",");
				}
				if(field.isAnnotationPresent(Column.class)) {
					Column column=field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}
			}
			parentClass=parentClass.getSuperclass();
		}
		String sql="INSERT INTO "+tableName+"("+fields.toString()+") values("+params.toString()+")";
		return sql;
	}
	@Override
	public void delete(long id) {
		String sql=createSQLDelete(id);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			//tu id-> Thong tin cua building tu db-> convert data tu resultset->entity
		
			
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	private String createSQLDelete(long id) {
		String tableName="";
		if(zClass.isAnnotationPresent(Entity.class)&&zClass.isAnnotationPresent(Table.class))
		{
			Table tableClass=zClass.getAnnotation(Table.class);
			tableName=tableClass.name();
		}
		StringBuilder sql=new StringBuilder();
		sql.append("DELETE FROM "+tableName+" WHERE id=" +id);
		return sql.toString();
	}
	@Override
	public void update(Object object) {
		String tableName="";
		if(zClass.isAnnotationPresent(Entity.class)&&zClass.isAnnotationPresent(Table.class))
		{
			Table tableClass=zClass.getAnnotation(Table.class);
			tableName=tableClass.name();
		}
		String sql=createSQLUpdate( object);
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			Class<?> aClass=object.getClass();
			Field[] fields=aClass.getDeclaredFields();
			int index=1;
			for(int i=0;i<fields.length;i++)
			{

				Field field=fields[i];
				field.setAccessible(true);
				if(field.get(object)!=null)
				{
				
				field=fields[i];
				field.setAccessible(true);
					statement.setObject(index, field.get(object));
				index++;
				}
		
			}
			Class<?> parentClass=aClass.getSuperclass();
			int indexParent=fields.length+1;
			while(parentClass!=null)
			{
				Field[] fieldsParent=parentClass.getDeclaredFields();
				for(int i=0;i<fieldsParent.length;i++)
				{
					Field field=fieldsParent[i];
					field.setAccessible(true);
					Column column=field.getAnnotation(Column.class);
					if(field.get(object)!=null&&!column.name().equals("id"))
					statement.setObject(indexParent, field.get(object));
					indexParent++;
				}
				parentClass=parentClass.getSuperclass();
			}
			statement.executeUpdate();
			//tu id-> Thong tin cua building tu db-> convert data tu resultset->entity
			resultSet=statement.getGeneratedKeys();
			connection.commit();
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	private String createSQLUpdate(Object object)  {
		StringBuilder sql=new StringBuilder();
		Class<?> aClass=object.getClass();
		Field[] fields=aClass.getDeclaredFields();
		String where=null;
		String tableName="";
		if(zClass.isAnnotationPresent(Entity.class)&&zClass.isAnnotationPresent(Table.class))
		{
			Table tableClass=zClass.getAnnotation(Table.class);
			tableName=tableClass.name();
		}
		sql.append("UPDATE "+tableName+" SET ");
		StringBuilder fieldss= new StringBuilder();
		try {
			for(Field field : aClass.getDeclaredFields())
			{
				if(field.isAnnotationPresent(Column.class)) {
					Column column=field.getAnnotation(Column.class);
					field.setAccessible(true);
//					if(field.get(object)!=null&&fieldss.length()>1) {
//						fieldss.append(","+column.name()+"=?");
//					}
//					if(field.get(object)!=null&&fieldss.length()<=1) {
//						fieldss.append(column.name()+"=?");
//					}
					String value=column.name()+ " = ? ";
					if(fieldss.length()>1)
						fieldss.append(",");
					fieldss.append(value);
				}
				
			}
			Class<?> parentClass=aClass.getSuperclass();
//			while(parentClass!=null) {
//				for(Field field:parentClass.getDeclaredFields()) {
//					Column column=field.getAnnotation(Column.class);
//					field.setAccessible(true);
//					if(field.get(object)!=null&&!column.name().equals("id")) {
//						fieldss.append(","+column.name()+"=?");
//					}
//				}
//				parentClass=parentClass.getSuperclass();
//			}
//			sql.append(fieldss.toString()+" ");
//			Class<?> parentClass1=aClass.getSuperclass();
//			while(parentClass1!=null) {
//				for(Field field:parentClass1.getDeclaredFields()) {
//					Column column=field.getAnnotation(Column.class);
//					field.setAccessible(true);
//					if(column.name().equals("id")) {
//						sql.append(" WHERE id="+field.get(object));
//					}
//				}
//				parentClass1=parentClass1.getSuperclass();
//			}
			
			while(parentClass!=null) {
				for(Field field:parentClass.getDeclaredFields()) {
					Column column=field.getAnnotation(Column.class);
					field.setAccessible(true);
					if(field.get(object)!=null&&!column.name().equals("id")) {
						fieldss.append(","+column.name()+"=?");
					}else {
						where=" where "+column.name()+"= ? ";
					}
				}
				parentClass=parentClass.getSuperclass();
			}
			sql.append(fieldss.toString()+" ");
			sql.append(where);
			return sql.toString();
			
		}catch (Exception e) {
			return null;
		}
		
	}
	@Override
	public T findById(Long id) {
		String tableName="";
		if(zClass.isAnnotationPresent(Entity.class)&&zClass.isAnnotationPresent(Table.class))
		{
			Table tableClass=zClass.getAnnotation(Table.class);
			tableName=tableClass.name();
		}
		StringBuilder sql=new StringBuilder("select * from "+tableName+" A  where id= "+id);
		ResultSetMapper<T> resultSetMapper=new ResultSetMapper<>();
		Connection connection = null;
		//PreparedStatement statement = null;
		Statement statement=null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			//statement = connection.prepareStatement(sql.toString());
			statement=connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
		    List<T> result= resultSetMapper.mapRow(resultSet, this.zClass);
		    return result.size()>0 ? result.get(0) :null;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}
	@Override
	public void delete(String sql) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			//tu id-> Thong tin cua building tu db-> convert data tu resultset->entity
			
			
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	@Override
	public List<T> findAll(String sql, Object... where) {
	
		ResultSetMapper<T> resultSetMapper=new ResultSetMapper<>();
		Connection connection = null;
		//PreparedStatement statement = null;
		Statement statement=null;
		ResultSet resultSet = null;
		try {
			connection = EntityManagerFactory.getConnection();
			//statement = connection.prepareStatement(sql.toString());
			statement=connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
		    return resultSetMapper.mapRow(resultSet, this.zClass);
		} catch (SQLException e) {
			return new ArrayList<>();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return new ArrayList<>();
			}
		}
	}
	
	
	

}
