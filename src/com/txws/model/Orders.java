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
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="price")
	private int price;
	@Column(name="time")
	private java.util.Date time;
	@Column(name="status")
	private java.lang.String status;
	@Column(name="message")
	private java.lang.String message;
	@OneToMany(mappedBy="orders",cascade={CascadeType.ALL})
	private java.util.Collection<Menu> menu;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="adId") 
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getMessage() {
		return message;
	}

	public void setMessage(java.lang.String message) {
		this.message = message;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public java.util.Collection<Menu> getMenu() {
		if (menu == null)
			menu = new java.util.HashSet<Menu>();
		return menu;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorMenu() {
		if (menu == null)
			menu = new java.util.HashSet<Menu>();
		return menu.iterator();
	}

	@SuppressWarnings("rawtypes")
	public void setMenu(java.util.Collection<Menu> newMenu) {
		removeAllMenu();
		for (java.util.Iterator iter = newMenu.iterator(); iter.hasNext();)
			addMenu((Menu) iter.next());
	}

	public void addMenu(Menu newMenu) {
		if (newMenu == null)
			return;
		if (this.menu == null)
			this.menu = new java.util.HashSet<Menu>();
		if (!this.menu.contains(newMenu)) {
			this.menu.add(newMenu);
			newMenu.setOrders(this);
		}
	}

	public void removeMenu(Menu oldMenu) {
		if (oldMenu == null)
			return;
		if (this.menu != null)
			if (this.menu.contains(oldMenu)) {
				this.menu.remove(oldMenu);
				oldMenu.setOrders((Orders) null);
			}
	}

	@SuppressWarnings("rawtypes")
	public void removeAllMenu() {
		if (menu != null) {
			Menu oldMenu;
			for (java.util.Iterator iter = getIteratorMenu(); iter.hasNext();) {
				oldMenu = (Menu) iter.next();
				iter.remove();
				oldMenu.setOrders((Orders) null);
			}
		}
	}

}
