package com.txws.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ���
 * 
 * @pdOid 3254645c-dea1-45b9-b574-0f70b1012a7f
 */
@Entity
@Table(name = "activity")
public class ActivityTable {
	/** @pdOid 08c6122d-1a5b-41dc-9f08-5fc885bae323 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	/**
	 * ����
	 * 
	 * @pdOid 33a9cd15-7c34-4cfb-8c14-55117a0a838e
	 */
	public java.lang.String activityName;
	/**
	 * ���ʼʱ��
	 * 
	 * @pdOid 3ba6b607-44bf-4592-ace7-dc0da5334edb
	 */
	public java.util.Date beginTime;
	/**
	 * �����ʱ��
	 * 
	 * @pdOid c46609f5-c120-4503-a7ca-eadf556bfdde
	 */
	public java.util.Date endTime;
	/**
	 * �����
	 * 
	 * @pdOid 5b22d3be-c171-41ac-9bd9-e71548114ed6
	 */
	public java.lang.String descri;

	/**
	 * @pdRoleInfo migr=no name=MenuTable assc=reference14
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	@OneToMany(mappedBy = "activityTable", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	public java.util.Collection<MenuTable> menuTable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getActivityName() {
		return activityName;
	}

	public void setActivityName(java.lang.String activityName) {
		this.activityName = activityName;
	}

	public java.util.Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public java.lang.String getDescri() {
		return descri;
	}

	public void setDescri(java.lang.String descri) {
		this.descri = descri;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<MenuTable> getMenuTable() {
		if (menuTable == null)
			menuTable = new java.util.HashSet<MenuTable>();
		return menuTable;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorMenuTable() {
		if (menuTable == null)
			menuTable = new java.util.HashSet<MenuTable>();
		return menuTable.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newMenuTable
	 */
	public void setMenuTable(java.util.Collection<MenuTable> newMenuTable) {
		removeAllMenuTable();
		for (java.util.Iterator iter = newMenuTable.iterator(); iter.hasNext();)
			addMenuTable((MenuTable) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newMenuTable
	 */
	public void addMenuTable(MenuTable newMenuTable) {
		if (newMenuTable == null)
			return;
		if (this.menuTable == null)
			this.menuTable = new java.util.HashSet<MenuTable>();
		if (!this.menuTable.contains(newMenuTable)) {
			this.menuTable.add(newMenuTable);
			newMenuTable.setActivityTable(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldMenuTable
	 */
	public void removeMenuTable(MenuTable oldMenuTable) {
		if (oldMenuTable == null)
			return;
		if (this.menuTable != null)
			if (this.menuTable.contains(oldMenuTable)) {
				this.menuTable.remove(oldMenuTable);
				oldMenuTable.setActivityTable((ActivityTable) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllMenuTable() {
		if (menuTable != null) {
			MenuTable oldMenuTable;
			for (java.util.Iterator iter = getIteratorMenuTable(); iter
					.hasNext();) {
				oldMenuTable = (MenuTable) iter.next();
				iter.remove();
				oldMenuTable.setActivityTable((ActivityTable) null);
			}
		}
	}

}