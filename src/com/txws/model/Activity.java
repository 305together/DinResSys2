package com.txws.model;

/***********************************************************************
 * Module:  Activity.java
 * Author:  Administrator
 * Purpose: Defines the Class Activity
 ***********************************************************************/

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 活动表
 * 
 * @pdOid 3254645c-dea1-45b9-b574-0f70b1012a7f */
@SuppressWarnings("unused")
@Entity
@Table(name="activity")
public class Activity {
   /** @pdOid 08c6122d-1a5b-41dc-9f08-5fc885bae323 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public long id;
   /** 活动名称
    * 
    * @pdOid 33a9cd15-7c34-4cfb-8c14-55117a0a838e */
   public java.lang.String activity;
   /** 活动开始时间
    * 
    * @pdOid 3ba6b607-44bf-4592-ace7-dc0da5334edb */
   public java.util.Date beginTime;
   /** 活动结束时间
    * 
    * @pdOid c46609f5-c120-4503-a7ca-eadf556bfdde */
   public java.util.Date endTime;
   /** 活动描述
    * 
    * @pdOid 5b22d3be-c171-41ac-9bd9-e71548114ed6 */
   public java.lang.String describe;
   
   /** @pdRoleInfo migr=no name=Promotion assc=activityPromotionReference coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Promotion> promotion;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Promotion> getPromotion() {
      if (promotion == null)
         promotion = new java.util.HashSet<Promotion>();
      return promotion;
   }
   
   /** @pdGenerated default iterator getter */
   @SuppressWarnings("rawtypes")
public java.util.Iterator getIteratorPromotion() {
      if (promotion == null)
         promotion = new java.util.HashSet<Promotion>();
      return promotion.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPromotion */
   public void setPromotion(java.util.Collection<Promotion> newPromotion) {
      removeAllPromotion();
      for (@SuppressWarnings("rawtypes")
	java.util.Iterator iter = newPromotion.iterator(); iter.hasNext();)
         addPromotion((Promotion)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPromotion */
   public void addPromotion(Promotion newPromotion) {
      if (newPromotion == null)
         return;
      if (this.promotion == null)
         this.promotion = new java.util.HashSet<Promotion>();
      if (!this.promotion.contains(newPromotion))
      {
         this.promotion.add(newPromotion);
         newPromotion.setActivity(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldPromotion */
   public void removePromotion(Promotion oldPromotion) {
      if (oldPromotion == null)
         return;
      if (this.promotion != null)
         if (this.promotion.contains(oldPromotion))
         {
            this.promotion.remove(oldPromotion);
            oldPromotion.setActivity((Activity)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPromotion() {
      if (promotion != null)
      {
         Promotion oldPromotion;
         for (@SuppressWarnings("rawtypes")
		java.util.Iterator iter = getIteratorPromotion(); iter.hasNext();)
         {
            oldPromotion = (Promotion)iter.next();
            iter.remove();
            oldPromotion.setActivity((Activity)null);
         }
      }
   }

}