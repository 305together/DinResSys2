package com.txws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/***********************************************************************
 * Module:  Authority.java
 * Author:  Administrator
 * Purpose: Defines the Class Authority
 ***********************************************************************/
import javax.persistence.Table;

/**
 * 权限表，记录所有权限类型
 * 
 * @pdOid 36ce0f13-21ba-46d9-a739-11aa56f7f891
 */
@Entity
@Table(name = "authority")
public class Authority {
	/** @pdOid 2e03f6af-c4b7-4d3b-8067-750cd232eacc */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public long id;
	/** @pdOid 422efc21-b072-4891-a756-5b6fcde80c95 */
	@Column(name="autho")
	public java.lang.String autho;
	/**
	 * 权限对应的URL路径
	 * 
	 * @pdOid be596efa-374a-42c6-b4fc-889cb9afab86
	 */
	@Column(name="authoUrl")
	public java.lang.String authoUrl;

	/**
	 * @pdRoleInfo migr=no name=UserAuthority assc=authoUserAuthoReference
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	//public java.util.Collection<UserAuthority> userAuthority;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.lang.String getAutho() {
		return autho;
	}

	public void setAutho(java.lang.String autho) {
		this.autho = autho;
	}

	public java.lang.String getAuthoUrl() {
		return authoUrl;
	}

	public void setAuthoUrl(java.lang.String authoUrl) {
		this.authoUrl = authoUrl;
	}
/*
	public java.util.Collection<UserAuthority> getUserAuthority() {
		if (userAuthority == null)
			userAuthority = new java.util.HashSet<UserAuthority>();
		return userAuthority;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorUserAuthority() {
		if (userAuthority == null)
			userAuthority = new java.util.HashSet<UserAuthority>();
		return userAuthority.iterator();
	}

	@SuppressWarnings("rawtypes")
	public void setUserAuthority(
			java.util.Collection<UserAuthority> newUserAuthority) {
		removeAllUserAuthority();
		for (java.util.Iterator iter = newUserAuthority.iterator(); iter
				.hasNext();)
			addUserAuthority((UserAuthority) iter.next());
	}

	public void addUserAuthority(UserAuthority newUserAuthority) {
		if (newUserAuthority == null)
			return;
		if (this.userAuthority == null)
			this.userAuthority = new java.util.HashSet<UserAuthority>();
		if (!this.userAuthority.contains(newUserAuthority)) {
			this.userAuthority.add(newUserAuthority);
			newUserAuthority.setAuthority(this);
		}
	}

	public void removeUserAuthority(UserAuthority oldUserAuthority) {
		if (oldUserAuthority == null)
			return;
		if (this.userAuthority != null)
			if (this.userAuthority.contains(oldUserAuthority)) {
				this.userAuthority.remove(oldUserAuthority);
				oldUserAuthority.setAuthority((Authority) null);
			}
	}

	@SuppressWarnings("rawtypes")
	public void removeAllUserAuthority() {
		if (userAuthority != null) {
			UserAuthority oldUserAuthority;
			for (java.util.Iterator iter = getIteratorUserAuthority(); iter
					.hasNext();) {
				oldUserAuthority = (UserAuthority) iter.next();
				iter.remove();
				oldUserAuthority.setAuthority((Authority) null);
			}
		}
	}*/

}
