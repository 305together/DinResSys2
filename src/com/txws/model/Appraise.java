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
@Table(name = "appraise")
public class Appraise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="praiseTime")
	private java.util.Date praiseTime;
	@Column(name="praiseLevel")
	private int praiseLevel = 5;
	@Column(name="detail")
	private java.lang.String detail;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="menuId")
	private Menu menu;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="userId")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getPraiseTime() {
		return praiseTime;
	}

	public void setPraiseTime(java.util.Date praiseTime) {
		this.praiseTime = praiseTime;
	}

	public int getPraiseLevel() {
		return praiseLevel;
	}

	public void setPraiseLevel(int praiseLevel) {
		this.praiseLevel = praiseLevel;
	}

	public java.lang.String getDetail() {
		return detail;
	}

	public void setDetail(java.lang.String detail) {
		this.detail = detail;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu newMenu) {
		if (this.menu == null || !this.menu.equals(newMenu)) {
			if (this.menu != null) {
				Menu oldMenu = this.menu;
				this.menu = null;
				oldMenu.removeAppraise(this);
			}
			if (newMenu != null) {
				this.menu = newMenu;
				this.menu.addAppraise(this);
			}
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User newUser) {
		if (this.user == null || !this.user.equals(newUser)) {
			if (this.user != null) {
				User oldUser = this.user;
				this.user = null;
				oldUser.removeAppraise(this);
			}
			if (newUser != null) {
				this.user = newUser;
				this.user.addAppraise(this);
			}
		}
	}
}
