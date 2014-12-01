package com.txws.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="activityName")
	private String activityName;
	@Column(name="beginTime")
	private java.util.Date beginTime;
	@Column(name="endTime")
	private java.util.Date endTime;
	@Column(name="describe")
	private String describe;
	@OneToMany(mappedBy="activity",cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
	private java.util.Collection<Promotion> promotion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public java.util.Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(java.util.Date beginTime) {
		this.beginTime = beginTime;
	}

	public java.util.Date getEndTime() {
		return endTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public java.util.Collection<Promotion> getPromotion() {
		if (promotion == null)
			promotion = new java.util.HashSet<Promotion>();
		return promotion;
	}
	
	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorPromotion() {
		if (promotion == null)
			promotion = new java.util.HashSet<Promotion>();
		return promotion.iterator();
	}

	public void setPromotion(java.util.Collection<Promotion> newPromotion) {
		removeAllPromotion();
		for (@SuppressWarnings("rawtypes")
		java.util.Iterator iter = newPromotion.iterator(); iter.hasNext();)
			addPromotion((Promotion) iter.next());
	}

	public void addPromotion(Promotion newPromotion) {
		if (newPromotion == null)
			return;
		if (this.promotion == null)
			this.promotion = new java.util.HashSet<Promotion>();
		if (!this.promotion.contains(newPromotion)) {
			this.promotion.add(newPromotion);
			newPromotion.setActivity(this);
		}
	}

	public void removePromotion(Promotion oldPromotion) {
		if (oldPromotion == null)
			return;
		if (this.promotion != null)
			if (this.promotion.contains(oldPromotion)) {
				this.promotion.remove(oldPromotion);
				oldPromotion.setActivity((Activity) null);
			}
	}

	public void removeAllPromotion() {
		if (promotion != null) {
			Promotion oldPromotion;
			for (@SuppressWarnings("rawtypes")
			java.util.Iterator iter = getIteratorPromotion(); iter.hasNext();) {
				oldPromotion = (Promotion) iter.next();
				iter.remove();
				oldPromotion.setActivity((Activity) null);
			}
		}
	}

}