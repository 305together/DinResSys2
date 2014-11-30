package com.txws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/***********************************************************************
 * Module:  Authority.java
 * Author:  Administrator
 * Purpose: Defines the Class Authority
 ***********************************************************************/
import javax.persistence.Table;

/** 权限表，记录所有权限类型
 * 
 * @pdOid 36ce0f13-21ba-46d9-a739-11aa56f7f891 */
@Entity
@Table(name="authority")
public class Authority {
   /** @pdOid 2e03f6af-c4b7-4d3b-8067-750cd232eacc */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public long id;
   /** @pdOid 422efc21-b072-4891-a756-5b6fcde80c95 */
   public java.lang.String autho;
   /** 权限对应的URL路径
    * 
    * @pdOid be596efa-374a-42c6-b4fc-889cb9afab86 */
   public java.lang.String authoUrl;
   
   /** @pdRoleInfo migr=no name=UserAuthority assc=authoUserAuthoReference coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<UserAuthority> userAuthority;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<UserAuthority> getUserAuthority() {
      if (userAuthority == null)
         userAuthority = new java.util.HashSet<UserAuthority>();
      return userAuthority;
   }
   
   /** @pdGenerated default iterator getter */
   @SuppressWarnings("rawtypes")
public java.util.Iterator getIteratorUserAuthority() {
      if (userAuthority == null)
         userAuthority = new java.util.HashSet<UserAuthority>();
      return userAuthority.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUserAuthority */
   @SuppressWarnings("rawtypes")
public void setUserAuthority(java.util.Collection<UserAuthority> newUserAuthority) {
      removeAllUserAuthority();
      for (java.util.Iterator iter = newUserAuthority.iterator(); iter.hasNext();)
         addUserAuthority((UserAuthority)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUserAuthority */
   public void addUserAuthority(UserAuthority newUserAuthority) {
      if (newUserAuthority == null)
         return;
      if (this.userAuthority == null)
         this.userAuthority = new java.util.HashSet<UserAuthority>();
      if (!this.userAuthority.contains(newUserAuthority))
      {
         this.userAuthority.add(newUserAuthority);
         newUserAuthority.setAuthority(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldUserAuthority */
   public void removeUserAuthority(UserAuthority oldUserAuthority) {
      if (oldUserAuthority == null)
         return;
      if (this.userAuthority != null)
         if (this.userAuthority.contains(oldUserAuthority))
         {
            this.userAuthority.remove(oldUserAuthority);
            oldUserAuthority.setAuthority((Authority)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   @SuppressWarnings("rawtypes")
public void removeAllUserAuthority() {
      if (userAuthority != null)
      {
         UserAuthority oldUserAuthority;
         for (java.util.Iterator iter = getIteratorUserAuthority(); iter.hasNext();)
         {
            oldUserAuthority = (UserAuthority)iter.next();
            iter.remove();
            oldUserAuthority.setAuthority((Authority)null);
         }
      }
   }

}
