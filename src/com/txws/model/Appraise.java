package com.txws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 用户对菜单的评价表
 * 
 * @pdOid 3a6a2bee-7d21-4ef5-bf9e-6545da8ba32d
 */
@Entity
@Table(name = "appraise")
public class Appraise {
	/** @pdOid 654728c9-23c1-4233-b2d4-b45e5080c496 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	/** @pdOid 5d0e323b-5e1f-408b-94b2-c7f37e35ba84 */
	@Column(name="praiseTime")
	public java.util.Date praiseTime;
	/**
	 * 用户对菜单的评价等级（1-5）
	 * 
	 * @pdOid 0e596695-2a92-4a80-b137-b2f78d81effb
	 */
	@Column(name="praiseLevel")
	public int praiseLevel = 5;
	/**
	 * 用户对菜单的评价内容
	 * 
	 * @pdOid ec6cca96-c5a3-4685-a77a-3067d03295e2
	 */
	@Column(name="detail")
	public java.lang.String detail;

	/** @pdRoleInfo migr=no name=Menu assc=menuAppraiseReference mult=1..1 side=A */
	//public Menu menu;
	/** @pdRoleInfo migr=no name=User assc=userAppraiseReference mult=1..1 side=A */
	//public User user;

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

/*	public Menu getMenu() {
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
*/
}
