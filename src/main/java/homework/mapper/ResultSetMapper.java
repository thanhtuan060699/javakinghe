package homework.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import homework.annotation.Column;
import homework.annotation.Entity;


public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs,Class<T> zClass){
		List<T> results=new ArrayList<>();
		try {
		
			if(zClass.isAnnotationPresent(Entity.class))
			{
				ResultSetMetaData resultSetMetaData=rs.getMetaData();
				Field[] fields=zClass.getDeclaredFields();
				while(rs.next())
				{
					T object=zClass.newInstance();
					for(int i=0;i<resultSetMetaData.getColumnCount();i++)
					{
						String columnName=resultSetMetaData.getColumnName(i+1);
						Object columnValue=rs.getObject(i+1);
						convertResultSetToEntity(fields,columnName,columnValue,object);
						Class<?> parentClass=zClass.getSuperclass();
						while(parentClass!=null)
						{
							Field[] fieldParents=parentClass.getDeclaredFields();
							convertResultSetToEntity(fieldParents,columnName,columnValue,object);
							parentClass=parentClass.getSuperclass();
						}
					}
					results.add(object);
				}
		
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return results;
	}
	private void convertResultSetToEntity(Field[] fields,String columnName,Object columnValue,T object)
	{
		try {
			for(Field field:fields)
			{
				if(field.isAnnotationPresent(Column.class))
				{
					Column column=field.getAnnotation(Column.class);
					if(column.name().equals(columnName)&&columnValue!=null)
					{
						BeanUtils.setProperty(object, field.getName(), columnValue);
						break;
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
