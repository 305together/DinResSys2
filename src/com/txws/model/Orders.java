package com.txws.model;

/***********************************************************************
 * Module:  Orders.java
 * Author:  Administrator
 * Purpose: Defines the Class Orders
 ***********************************************************************/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/** 订单表
 * 
 * @pdOid eb1f3165-feed-47c9-973c-06ac842aad6a */
@Entity
@Table(name="orders")
public class Orders {
   /** @pdOid 5b2ef31c-0e1f-4e31-9abf-6e4bd3ec16b1 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public int id;
   /** 总价，下单时计算填入
    * 
    * @pdOid ddb7873b-98a3-488e-a221-4034701e429a */
   public int price;
   /** 下单时间
    * 
    * @pdOid 51a53f3d-498d-49d7-b37a-dc8cd3ab976e */
   public java.util.Date time;
   /** 订单状态
    * 
    * @pdOid 1f0398e1-6549-4d66-a5fd-09dc2b890bc7 */
   public java.lang.String status;
   /** 用户留言
    * 
    * @pdOid cdb23a12-0f91-4093-814c-16213aaa1f65 */
   public java.lang.String message;
   
   /** @pdRoleInfo migr=no name=Menu assc=orderMenuReference coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Composition */
   public java.util.Collection<Menu> menu;
   /** @pdRoleInfo migr=no name=User assc=userOrderReference mult=1..1 side=A */
   public User user;
   /** @pdRoleInfo migr=no name=Address assc=orderAddressReference mult=1..1 side=A */
   public Address address;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Menu> getMenu() {
      if (menu == null)
         menu = new java.util.HashSet<Menu>();
      return menu;
   }
   
   /** @pdGenerated default iterator getter */
   @SuppressWarnings("rawtypes")
public java.util.Iterator getIteratorMenu() {
      if (menu == null)
         menu = new java.util.HashSet<Menu>();
      return menu.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMenu */
   @SuppressWarnings("rawtypes")
public void setMenu(java.util.Collection<Menu> newMenu) {
      removeAllMenu();
      for (java.util.Iterator iter = newMenu.iterator(); iter.hasNext();)
         addMenu((Menu)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMenu */
   public void addMenu(Menu newMenu) {
      if (newMenu == null)
         return;
      if (this.menu == null)
         this.menu = new java.util.HashSet<Menu>();
      if (!this.menu.contains(newMenu))
      {
         this.menu.add(newMenu);
         newMenu.setOrders(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldMenu */
   public void removeMenu(Menu oldMenu) {
      if (oldMenu == null)
         return;
      if (this.menu != null)
         if (this.menu.contains(oldMenu))
         {
            this.menu.remove(oldMenu);
            oldMenu.setOrders((Orders)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   @SuppressWarnings("rawtypes")
public void removeAllMenu() {
      if (menu != null)
      {
         Menu oldMenu;
         for (java.util.Iterator iter = getIteratorMenu(); iter.hasNext();)
         {
            oldMenu = (Menu)iter.next();
            iter.remove();
            oldMenu.setOrders((Orders)null);
         }
      }
   }

}