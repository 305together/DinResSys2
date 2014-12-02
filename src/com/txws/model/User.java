package com.txws.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private java.lang.String name;
	@Column(name="password")
	private java.lang.String password;
	@Column(name="tel")
	private java.lang.String tel;
	@Column(name="authoLevel")
	private int authoLevel = 2;
	@OneToMany(mappedBy="user",cascade={CascadeType.ALL})
	private java.util.Collection<Address> address;
	@OneToMany(mappedBy="user",cascade={CascadeType.ALL})
	private java.util.Collection<Appraise> appraise;
	@OneToMany(mappedBy="user",cascade={CascadeType.ALL})
	private java.util.Collection<Orders> orders;
	@OneToMany(mappedBy="user",cascade={CascadeType.ALL})
	private java.util.Collection<UserAuthority> userAuthority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public int getAuthoLevel() {
		return authoLevel;
	}

	public void setAuthoLevel(int authoLevel) {
		this.authoLevel = authoLevel;
	}
	
	public java.util.Collection<Orders> getOrders() {
		if (orders == null)
			orders = new java.util.HashSet<Orders>();
		return orders;
	}
	
	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorOrders() {
		if (orders == null)
			orders = new java.util.HashSet<Orders>();
		return orders.iterator();
	}
	
	@SuppressWarnings("rawtypes")
	public void setOrders(java.util.Collection<Orders> newOrders) {
		removeAllOrders();
		for (java.util.Iterator iter = newOrders.iterator(); iter.hasNext();)
			addOrders((Orders) iter.next());
	}
	
	public void addOrders(Orders newOrders) {
		if (newOrders == null)
			return;
		if (this.orders == null)
			this.orders = new java.util.HashSet<Orders>();
		if (!this.orders.contains(newOrders)) {
			this.orders.add(newOrders);
			newOrders.setUser(this);
		}
	}
	
	public void removeOrders(Orders oldOrders) {
		if (oldOrders == null)
			return;
		if (this.orders != null)
			if (this.orders.contains(oldOrders)) {
				this.orders.remove(oldOrders);
				oldOrders.setUser((User) null);
			}
	}
	
	@SuppressWarnings("rawtypes")
	public void removeAllOrders() {
		if (orders != null) {
			Orders oldOrders;
			for (java.util.Iterator iter = getIteratorOrders(); iter.hasNext();) {
				oldOrders = (Orders) iter.next();
				iter.remove();
				oldOrders.setUser((User) null);
			}
		}
	}
	
	public java.util.Collection<Address> getAddress() {
		if (address == null)
			address = new java.util.HashSet<Address>();
		return address;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorAddress() {
		if (address == null)
			address = new java.util.HashSet<Address>();
		return address.iterator();
	}

	@SuppressWarnings("rawtypes")
	public void setAddress(java.util.Collection<Address> newAddress) {
		removeAllAddress();
		for (java.util.Iterator iter = newAddress.iterator(); iter.hasNext();)
			addAddress((Address) iter.next());
	}

	public void addAddress(Address newAddress) {
		if (newAddress == null)
			return;
		if (this.address == null)
			this.address = new java.util.HashSet<Address>();
		if (!this.address.contains(newAddress)) {
			this.address.add(newAddress);
			newAddress.setUser(this);
		}
	}

	public void removeAddress(Address oldAddress) {
		if (oldAddress == null)
			return;
		if (this.address != null)
			if (this.address.contains(oldAddress)) {
				this.address.remove(oldAddress);
				oldAddress.setUser((User) null);
			}
	}

	@SuppressWarnings("rawtypes")
	public void removeAllAddress() {
		if (address != null) {
			Address oldAddress;
			for (java.util.Iterator iter = getIteratorAddress(); iter.hasNext();) {
				oldAddress = (Address) iter.next();
				iter.remove();
				oldAddress.setUser((User) null);
			}
		}
	}

	public java.util.Collection<Appraise> getAppraise() {
		if (appraise == null)
			appraise = new java.util.HashSet<Appraise>();
		return appraise;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorAppraise() {
		if (appraise == null)
			appraise = new java.util.HashSet<Appraise>();
		return appraise.iterator();
	}

	@SuppressWarnings("rawtypes")
	public void setAppraise(java.util.Collection<Appraise> newAppraise) {
		removeAllAppraise();
		for (java.util.Iterator iter = newAppraise.iterator(); iter.hasNext();)
			addAppraise((Appraise) iter.next());
	}

	public void addAppraise(Appraise newAppraise) {
		if (newAppraise == null)
			return;
		if (this.appraise == null)
			this.appraise = new java.util.HashSet<Appraise>();
		if (!this.appraise.contains(newAppraise)) {
			this.appraise.add(newAppraise);
			newAppraise.setUser(this);
		}
	}

	public void removeAppraise(Appraise oldAppraise) {
		if (oldAppraise == null)
			return;
		if (this.appraise != null)
			if (this.appraise.contains(oldAppraise)) {
				this.appraise.remove(oldAppraise);
				oldAppraise.setUser((User) null);
			}
	}

	@SuppressWarnings("rawtypes")
	public void removeAllAppraise() {
		if (appraise != null) {
			Appraise oldAppraise;
			for (java.util.Iterator iter = getIteratorAppraise(); iter
					.hasNext();) {
				oldAppraise = (Appraise) iter.next();
				iter.remove();
				oldAppraise.setUser((User) null);
			}
		}
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
			newUserAuthority.setUser(this);
		}
	}

	public void removeUserAuthority(UserAuthority oldUserAuthority) {
		if (oldUserAuthority == null)
			return;
		if (this.userAuthority != null)
			if (this.userAuthority.contains(oldUserAuthority)) {
				this.userAuthority.remove(oldUserAuthority);
				oldUserAuthority.setUser((User) null);
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
				oldUserAuthority.setUser((User) null);
			}
		}
	}

}
