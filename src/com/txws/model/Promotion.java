package com.txws.model;
/***********************************************************************
 * Module:  Promotion.java
 * Author:  Administrator
 * Purpose: Defines the Class Promotion
 ***********************************************************************/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** 优惠表，记录每个活动中菜单的优惠情况
 * 
 * @pdOid 78ab9aec-06bd-4b74-af10-6dfed1637206 */
@Entity
@Table(name="activity")
public class Promotion {
   /** @pdOid 08856670-36ee-4444-a9d6-a02066351cab */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public int id;
   /** 折扣，0-100
    * 
    * @pdOid 3820febf-26d5-478e-ab65-3becb02ebdc7 */
   public int discount = 100;
   /** 降价，该值小于菜单项价格
    * 
    * @pdOid d52f2c71-aff8-4b1b-9076-5de4ceb2a425 */
   public int lessen = 0;
   
   /** @pdRoleInfo migr=no name=Activity assc=activityPromotionReference mult=1..1 side=A */
   public Activity activity;
   /** @pdRoleInfo migr=no name=Menu assc=menuPromotionReference mult=1..1 side=A */
   public Menu menu;
   
   
   /** @pdGenerated default parent getter */
   public Activity getActivity() {
      return activity;
   }
   
   /** @pdGenerated default parent setter
     * @param newActivity */
   public void setActivity(Activity newActivity) {
      if (this.activity == null || !this.activity.equals(newActivity))
      {
         if (this.activity != null)
         {
            Activity oldActivity = this.activity;
            this.activity = null;
            oldActivity.removePromotion(this);
         }
         if (newActivity != null)
         {
            this.activity = newActivity;
            this.activity.addPromotion(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Menu getMenu() {
      return menu;
   }
   
   /** @pdGenerated default parent setter
     * @param newMenu */
   public void setMenu(Menu newMenu) {
      if (this.menu == null || !this.menu.equals(newMenu))
      {
         if (this.menu != null)
         {
            Menu oldMenu = this.menu;
            this.menu = null;
            oldMenu.removePromotion(this);
         }
         if (newMenu != null)
         {
            this.menu = newMenu;
            this.menu.addPromotion(this);
         }
      }
   }

}
