package com.txws.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="ad")
	private java.lang.String ad;
	@Column(name="isDefault")
	private int isDefault = 0;

	/** @pdRoleInfo migr=no name=Orders assc=ordersAddressReference mult=1..1 */
	//public Orders orders;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="userId")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getAd() {
		return ad;
	}

	public void setAd(java.lang.String ad) {
		this.ad = ad;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User newUser) {
		if (this.user == null || !this.user.equals(newUser)) {
			if (this.user != null) {
				User oldUser = this.user;
				this.user = null;
				oldUser.removeAddress(this);
			}
			if (newUser != null) {
				this.user = newUser;
				this.user.addAddress(this);
			}
		}
	}
	
/*
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
*/
}