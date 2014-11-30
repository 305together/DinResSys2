package com.txws.model;
/***********************************************************************
 * Module:  UserAuthority.java
 * Author:  Administrator
 * Purpose: Defines the Class UserAuthority
 ***********************************************************************/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/** 用户-权限表。本系统有三种用户类型，每种类型权限不同
 * 
 * @pdOid 756a59ec-32ac-4f83-8f54-59a18126fdf7 */
@Entity
@Table(name="userauthority")
public class UserAuthority {
   /** @pdOid d876c04c-05e0-42cd-9587-26b252247f87 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public int id;
   
   /** @pdRoleInfo migr=no name=Authority assc=authoUserAuthoReference mult=1..1 side=A */
   public Authority authority;
   /** @pdRoleInfo migr=no name=User assc=userUserAuthoReference mult=1..1 side=A */
   public User user;
   
   
   /** @pdGenerated default parent getter */
   public Authority getAuthority() {
      return authority;
   }
   
   /** @pdGenerated default parent setter
     * @param newAuthority */
   public void setAuthority(Authority newAuthority) {
      if (this.authority == null || !this.authority.equals(newAuthority))
      {
         if (this.authority != null)
         {
            Authority oldAuthority = this.authority;
            this.authority = null;
            oldAuthority.removeUserAuthority(this);
         }
         if (newAuthority != null)
         {
            this.authority = newAuthority;
            this.authority.addUserAuthority(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public User getUser() {
      return user;
   }
   
   /** @pdGenerated default parent setter
     * @param newUser */
   public void setUser(User newUser) {
      if (this.user == null || !this.user.equals(newUser))
      {
         if (this.user != null)
         {
            User oldUser = this.user;
            this.user = null;
            oldUser.removeUserAuthority(this);
         }
         if (newUser != null)
         {
            this.user = newUser;
            this.user.addUserAuthority(this);
         }
      }
   }

}
