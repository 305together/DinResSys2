package com.txws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 用户地址表，用于每个用户有多个地址
 * 
 * @pdOid e6445ad3-bcec-4e0f-bac4-bb488732289b
 */
@Entity
@Table(name = "address")
public class Address {
	/** @pdOid 69b74cc8-cdc3-4a9c-b047-3bf27eeae4da */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	/**
	 * 地址信息
	 * 
	 * @pdOid 0f7572ad-be43-4f40-baec-54875fb62db7
	 */
	@Column(name="ad")
	public java.lang.String ad;
	/**
	 * 是否默认值
	 * 
	 * @pdOid b725f5c3-e6a7-482c-b932-900bdc13c343
	 */
	@Column(name="isDefault")
	public int isDefault = 0;

	/** @pdRoleInfo migr=no name=Orders assc=ordersAddressReference mult=1..1 */
	//public Orders orders;
	/** @pdRoleInfo migr=no name=User assc=userAddressReference mult=1..1 side=A */
	//public User user;

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
/*
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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
*/
}