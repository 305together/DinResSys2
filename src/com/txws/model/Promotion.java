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
@Table(name = "activity")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="discount")
	private int discount = 100;
	@Column(name="lessen")
	private int lessen = 0;
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="activityId",referencedColumnName="id") 
	private Activity activity;
	//private Menu menu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getLessen() {
		return lessen;
	}

	public void setLessen(int lessen) {
		this.lessen = lessen;
	}

	public Activity getActivity() {
		return activity;
	}
/*
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu newMenu) {
		if (this.menu == null || !this.menu.equals(newMenu)) {
			if (this.menu != null) {
				Menu oldMenu = this.menu;
				this.menu = null;
				oldMenu.removePromotion(this);
			}
			if (newMenu != null) {
				this.menu = newMenu;
				this.menu.addPromotion(this);
			}
		}
	}
*/
	public void setActivity(Activity newActivity) {
		if (this.activity == null || !this.activity.equals(newActivity)) {
			if (this.activity != null) {
				Activity oldActivity = this.activity;
				this.activity = null;
				oldActivity.removePromotion(this);
			}
			if (newActivity != null) {
				this.activity = newActivity;
				this.activity.addPromotion(this);
			}
		}
	}

}
