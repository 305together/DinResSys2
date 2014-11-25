package com.txws.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.txws.dao.interfaces.ICommonDAO;

@Repository("commonDAO")
public class CommonDAOImpl extends BasicSupportDao implements ICommonDAO {
	private static final long serialVersionUID = 1744644549907514077L;
 
	public <T> T getObject(Class<T> clazz, Integer id) {
		return this.getHibernateTemplate().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getObjects(String QueryName) {
		return this.getHibernateTemplate().find("from " + QueryName);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getObjectsandRequire(String queryType,String requirement) {
		return (List<T>) this.getHibernateTemplate().find("from " + queryType + requirement);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getObjectsByKeyandRequire(Class<T> clazz, String keyName, String KeyValue,String requirement) {
		System.out.println("CHECK:"+"from " +  clazz + " where " + keyName + "="+KeyValue + requirement);
		return (List<T>) this.getHibernateTemplate().find("from " +  clazz.getSimpleName() + " where " + keyName + "="+KeyValue + requirement);	
	}
	
	public <T> void update(T obj) {
		
		this.getHibernateTemplate().update( obj );
	}

	public <T> void save(T obj) {
		this.getHibernateTemplate().save( obj );
	}
	
	public <T> void delete(T obj){
		this.getHibernateTemplate().delete(obj);
	}

	public <T> void deleteAll(List<T> list){
		this.getHibernateTemplate().deleteAll(list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getObjectsByKey(Class<T> clazz, String keyName,String KeyValue) {

		return (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName()+ " where " + keyName + "= '" + KeyValue +"'");
	}

	@Override
	public String shiftEnter(String srcStr) {

		System.out.println("srcStr: "+srcStr);
		String newStr = srcStr.replaceAll("\r\n", "<br>"); // �滻�س����з�
		newStr = newStr.replaceAll(" ", "&nbsp;");// �滻�ո��
		System.out.println("newStr: "+newStr);
		return newStr;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getObjectsByKeys(T t) {
		return this.getHibernateTemplate().findByExample(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getObjectsByWhereSQL(String queryString) {
		System.out.println(queryString);
		return this.getHibernateTemplate().find(queryString);
	}
}
