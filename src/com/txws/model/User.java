package com.txws.model;
/***********************************************************************
 * Module:  User.java
 * Author:  Administrator
 * Purpose: Defines the Class User
 ***********************************************************************/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** 用户表，记录用户信息
 * 
 * @pdOid b49a8587-1d80-4e62-8e88-e1955dd4c4cc */
@Entity
@Table(name="user")
public class User {
   /** @pdOid 3ed67683-f2e5-4493-822e-fa2895d4c762 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public long id;
   /** 用户昵称
    * 
    * @pdOid b05cc0fc-796c-421d-b4c0-277a2afa9aa7 */
   public java.lang.String name;
   /** 用户密码
    * 
    * @pdOid ee9f90ad-736c-4254-bdc4-8b075d9fc2cd */
   public java.lang.String password;
   /** 用户手机号，用于订单上的联系方式
    * 
    * @pdOid 99cf7223-81cb-44dd-aa16-7a77904aa8fc */
   public java.lang.String tel;
   /** 用户等级，0代表超级管理员，1代表菜单管理人员，2代表普通用户
    * 
    * @pdOid 83a6ecbf-27ca-4078-a5a9-5e8ece608bf5 */
   public int authoLevel = 2;
   
   /** @pdRoleInfo migr=no name=Address assc=userAddressReference coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Address> address;
   /** @pdRoleInfo migr=no name=Orders assc=userOrderReference mult=1..1 */
   public Orders orders;
   /** @pdRoleInfo migr=no name=Appraise assc=userAppraiseReference coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Appraise> appraise;
   /** @pdRoleInfo migr=no name=UserAuthority assc=userUserAuthoReference coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<UserAuthority> userAuthority;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Address> getAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address;
   }
   
   /** @pdGenerated default iterator getter */
   @SuppressWarnings("rawtypes")
public java.util.Iterator getIteratorAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAddress */
   @SuppressWarnings("rawtypes")
public void setAddress(java.util.Collection<Address> newAddress) {
      removeAllAddress();
      for (java.util.Iterator iter = newAddress.iterator(); iter.hasNext();)
         addAddress((Address)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAddress */
   public void addAddress(Address newAddress) {
      if (newAddress == null)
         return;
      if (this.address == null)
         this.address = new java.util.HashSet<Address>();
      if (!this.address.contains(newAddress))
      {
         this.address.add(newAddress);
         newAddress.setUser(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAddress */
   public void removeAddress(Address oldAddress) {
      if (oldAddress == null)
         return;
      if (this.address != null)
         if (this.address.contains(oldAddress))
         {
            this.address.remove(oldAddress);
            oldAddress.setUser((User)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   @SuppressWarnings("rawtypes")
public void removeAllAddress() {
      if (address != null)
      {
         Address oldAddress;
         for (java.util.Iterator iter = getIteratorAddress(); iter.hasNext();)
         {
            oldAddress = (Address)iter.next();
            iter.remove();
            oldAddress.setUser((User)null);
         }
      }
   }
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
         newAppraise.setUser(this);      
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
            oldAppraise.setUser((User)null);
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
            oldAppraise.setUser((User)null);
         }
      }
   }
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
         newUserAuthority.setUser(this);      
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
            oldUserAuthority.setUser((User)null);
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
            oldUserAuthority.setUser((User)null);
         }
      }
   }

}
