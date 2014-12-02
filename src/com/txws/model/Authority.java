package com.txws.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/***********************************************************************
 * Module:  Authority.java
 * Author:  Administrator
 * Purpose: Defines the Class Authority
 ***********************************************************************/
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="autho")
	private java.lang.String autho;
	@Column(name="authoUrl")
	private java.lang.String authoUrl;
	@OneToMany(mappedBy="authority",cascade={CascadeType.ALL})
	private java.util.Collection<UserAuthority> userAuthority;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	}

}
