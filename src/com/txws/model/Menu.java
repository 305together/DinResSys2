package com.txws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/***********************************************************************
 * Module:  Menu.java
 * Author:  Administrator
 * Purpose: Defines the Class Menu
 ***********************************************************************/
import javax.persistence.Table;

/** 菜单表
 * 
 * @pdOid ae29aa4c-c677-4214-89fa-9f22477142c3 */
@Entity
@Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public long id;
   /** 菜单项名称
    * 
    * @pdOid 3d0f3be0-3103-4057-b724-de968de5023d */
   public java.lang.String item;
   /** 菜单项价格
    * 
    * @pdOid 9892e320-2ef5-439c-9063-c519842a94be */
   public int price;
   /** 是否热销菜单项
    * 
    * @pdOid 2cc01ad7-78be-480c-b953-01f98f6efe2e */
   public int isHot = 0;
   /** @pdOid 1ad506e9-93e8-41a7-8ce7-cc0238a982d8 */
   public int praiseNum = 0;
   /** 菜单状态（已售完0、在售1）
    * 
    * @pdOid 62104d3a-d5d8-481c-9d81-9580b77dc006 */
   public int status = 1;
   /** 是否参与促销（没有0，有1）
    * 
    * @pdOid ba4c8232-f086-4829-92f6-4465c125b220 */
   public int isInActivity = 0;
   /** @pdOid 41d13cdb-95b2-42b1-a271-4d1f389e73c9 */
   public java.lang.String picture;
   /** 菜单描述
    * 
    * @pdOid 33edef61-524a-4285-9927-8ff2bbd76177 */
   public java.lang.String describe;
   
   /** @pdRoleInfo migr=no name=Appraise assc=menuAppraiseReference coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Appraise> appraise;
   /** @pdRoleInfo migr=no name=Promotion assc=menuPromotionReference coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Promotion> promotion;
   /** @pdRoleInfo migr=no name=MenuType assc=menuMenuTypeRefenrence mult=1..1 */
   public MenuType menuType;
   /** @pdRoleInfo migr=no name=Orders assc=orderMenuReference mult=1..1 side=A */
   public Orders orders;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Appraise> getAppraise() {
      if (appraise == null)
         appraise = new java.util.HashSet<Appraise>();
      return appraise;
   }
   
   /** @pdGenerated default iterator getter */
   @SuppressWarnings("rawtypes")
public java.util.Iterator getIteratorAppraise() {
      if (appraise == null)
         appraise = new java.util.HashSet<Appraise>();
      return appraise.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAppraise */
   @SuppressWarnings("rawtypes")
public void setAppraise(java.util.Collection<Appraise> newAppraise) {
      removeAllAppraise();
      for (java.util.Iterator iter = newAppraise.iterator(); iter.hasNext();)
         addAppraise((Appraise)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAppraise */
   public void addAppraise(Appraise newAppraise) {
      if (newAppraise == null)
         return;
      if (this.appraise == null)
         this.appraise = new java.util.HashSet<Appraise>();
      if (!this.appraise.contains(newAppraise))
      {
         this.appraise.add(newAppraise);
         newAppraise.setMenu(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAppraise */
   public void removeAppraise(Appraise oldAppraise) {
      if (oldAppraise == null)
         return;
      if (this.appraise != null)
         if (this.appraise.contains(oldAppraise))
         {
            this.appraise.remove(oldAppraise);
            oldAppraise.setMenu((Menu)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   @SuppressWarnings("rawtypes")
public void removeAllAppraise() {
      if (appraise != null)
      {
         Appraise oldAppraise;
         for (java.util.Iterator iter = getIteratorAppraise(); iter.hasNext();)
         {
            oldAppraise = (Appraise)iter.next();
            iter.remove();
            oldAppraise.setMenu((Menu)null);
         }
      }
   }
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
   @SuppressWarnings("rawtypes")
public void setPromotion(java.util.Collection<Promotion> newPromotion) {
      removeAllPromotion();
      for (java.util.Iterator iter = newPromotion.iterator(); iter.hasNext();)
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
         newPromotion.setMenu(this);      
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
            oldPromotion.setMenu((Menu)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   @SuppressWarnings("rawtypes")
public void removeAllPromotion() {
      if (promotion != null)
      {
         Promotion oldPromotion;
         for (java.util.Iterator iter = getIteratorPromotion(); iter.hasNext();)
         {
            oldPromotion = (Promotion)iter.next();
            iter.remove();
            oldPromotion.setMenu((Menu)null);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Orders getOrders() {
      return orders;
   }
   
   /** @pdGenerated default parent setter
     * @param newOrders */
   public void setOrders(Orders newOrders) {
      if (this.orders == null || !this.orders.equals(newOrders))
      {
         if (this.orders != null)
         {
            Orders oldOrders = this.orders;
            this.orders = null;
            oldOrders.removeMenu(this);
         }
         if (newOrders != null)
         {
            this.orders = newOrders;
            this.orders.addMenu(this);
         }
      }
   }

}
