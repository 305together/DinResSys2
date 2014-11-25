package com.txws.dao.interfaces;

import java.util.LinkedHashMap;

import com.txws.model.QueryResult;


public interface IPageDAO<T> {
	public String getClassName();
	
	public QueryResult<T> getScrollData();
	
	/** @param firstIndex ��ʼ����
	 *  @param perRecord ÿҳ��¼��
	 */
	public QueryResult<T> getScrollData(final int firstIndex, final int perRecord);
	
	/** @param firstIndex ��ʼ����
	 *  @param perRecord ÿҳ��¼��
	 *  @param whereSql where���
	 *  @param queryParams ��ѯ����
	 *  @return ��ҳ���
	 */
	public QueryResult<T> getScrollData(final int firstIndex, final int perRecord, final String whereSql, final Object[] queryParams);
	
	/** @param firstIndex ��ʼ����
	 *  @param perRecord ÿҳ��¼��
	 *  @param orderby �������
	 *  @return ��ҳ���
	 */
	public QueryResult<T> getScrollData(final int firstIndex, final int perRecord, final LinkedHashMap<String, String> orderby);
	
	/** @param firstIndex ��ʼ����
	 *  @param perRecord ÿҳ��¼��
	 *  @param whereSql where���
	 *  @param queryParams ��ѯ����
	 *  @param orderby �������
	 *  @return ��ҳ���
	 */
	public QueryResult<T> getScrollData(final int firstIndex, final int perRecord,
			final String whereSql, final Object[] queryParams, final LinkedHashMap<String, String> orderby);
}
