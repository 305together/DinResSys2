package com.txws.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.txws.model.QueryResult;
import com.txws.dao.interfaces.IPageDAO;

@Repository("pageDAO")
public class PageDAOImpl<T> extends BasicSupportDao implements IPageDAO<T>{

	private static final long serialVersionUID = -6751008618426265690L;
	protected String entityClassName = "";

	@Override
	public String getClassName(){
		return this.getClass().toString() + " ::" + getSuperClassGenricType(this.getClass()).toString()
				+ "::" + (getSuperClassGenricType(this.getClass())).getSimpleName();
	}
	
	@Override
	public QueryResult<T> getScrollData() {
		return getScrollData(-1,-1);
	}
	
	@Override
	public QueryResult<T> getScrollData(int firstIndex, int perRecord) {
		return this.getScrollData(firstIndex, perRecord, null, null, null);	
	}

	@Override
	public QueryResult<T> getScrollData(int firstIndex, int perRecord,
			String whereSql, Object[] queryParams) {
		return this.getScrollData(firstIndex, perRecord, whereSql, queryParams, null);	
	}

	@Override
	public QueryResult<T> getScrollData(int firstIndex, int perRecord,
			LinkedHashMap<String, String> orderby) {
		return this.getScrollData(firstIndex, perRecord, null, null, orderby);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<T> getScrollData(final int firstIndex, final int perRecord,
			final String whereSql, final Object[] queryParams, final LinkedHashMap<String, String> orderby) {
		
		final QueryResult<T> queryResult = new QueryResult<T>();
		entityClassName = getEntityName(getSuperClassGenricType(this.getClass()));
		
		super.getHibernateTemplate().execute(new HibernateCallback<T>()
		{

			@Override
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				String hql = "from " + entityClassName + " o" + 
						((whereSql==null || "".equals(whereSql.trim()) ? "" : " where " + whereSql)
						 + buildOrderby(orderby));
				System.out.println("hql:"+hql);
				Query query = session.createQuery(hql);
				setQueryParams(query, queryParams);
				queryResult.setTotalRecord(query.list().size());
				
				if (firstIndex!=-1 && perRecord!=-1) {
					query.setFirstResult(firstIndex).setMaxResults(perRecord);
				}
				
				queryResult.setResultList(query.list());
				
				return null;
			}
			
		});
		
		System.out.println(queryResult.getTotalRecord());
		return queryResult;
	}

	protected static <T> String getEntityName(Class<T> clazz) {
		String entityName = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);

		if(entity.name()!=null && !"".equals(entity.name())){
			entityName = entity.name();
		}
		
		return entityName;
	}

	protected static void setQueryParams(Query query, Object[] params){
		if (params!=null && params.length>0) {
			for (int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
				System.out.print(params[i] + " ");
				query.setParameter(i, params[i]);
			}
		} else {
		}
	}
	
	protected static String buildOrderby(LinkedHashMap<String, String> orderby) {
		StringBuilder sb = new StringBuilder("");
		if (orderby!=null && orderby.size()>0) {
			sb.append(" order by ");
			for(String key : orderby.keySet()){
				sb.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		else {
		}
		return sb.toString();
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz) {
    	return getSuperClassGenricType(clazz,0);
    }

	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index) {    

        Type genType = clazz.getGenericSuperclass();    
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;   
        }  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) { 
        	 throw new RuntimeException("�����������"+ (index<0 ? "����С��0" : "�����˲��������"));
        }      

        if (!(params[index] instanceof Class)) {
            return Object.class;   
        }
        return (Class) params[index];
    }

}





























