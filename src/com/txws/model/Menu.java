package com.txws.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/***********************************************************************
 * Module:  Menu.java
 * Author:  Administrator
 * Purpose: Defines the Class Menu
 ***********************************************************************/
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="item")
	private java.lang.String item;
	@Column(name="price")
	private int price;
	@Column(name="isHot")
	private int isHot = 0;
	@Column(name="orderNum")
	private int orderNum = 0;
	@Column(name="praiseNum")
	private int praiseNum = 0;
	@Column(name="status")
	private int status = 1;
	@Column(name="isInActivity")
	private int isInActivity = 0;
	@Column(name="discount")
	private int discount = 100;
	@Column(name="picture")
	private java.lang.String picture;
	@Column(name="describe")
	private java.lang.String describe;
	@OneToMany(mappedBy="menu",cascade={CascadeType.ALL})
	private java.util.Collection<Appraise> appraise;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="typeId")
	private Type type;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="typeId") 
	private Orders orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getItem() {
		return item;
	}

	public void setItem(java.lang.String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getIsHot() {
		return isHot;
	}

	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsInActivity() {
		return isInActivity;
	}

	public void setIsInActivity(int isInActivity) {
		this.isInActivity = isInActivity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public java.lang.String getPicture() {
		return picture;
	}

	public void setPicture(java.lang.String picture) {
		this.picture = picture;
	}

	public java.lang.String getDescribe() {
		return describe;
	}

	public void setDescribe(java.lang.String describe) {
		this.describe = describe;
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
			newAppraise.setMenu(this);
		}
	}

	public void removeAppraise(Appraise oldAppraise) {
		if (oldAppraise == null)
			return;
		if (this.appraise != null)
			if (this.appraise.contains(oldAppraise)) {
				this.appraise.remove(oldAppraise);
				oldAppraise.setMenu((Menu) null);
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
				oldAppraise.setMenu((Menu) null);
			}
		}
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

}
