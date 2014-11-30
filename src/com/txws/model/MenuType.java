package com.txws.model;

/***********************************************************************
 * Module:  MenuType.java
 * Author:  Administrator
 * Purpose: Defines the Class MenuType
 ***********************************************************************/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/** 菜式与类别的关联表
 * 
 * @pdOid ac410915-c8dd-4e5a-9b8c-d21a4cf60d7d */
@Entity
@Table(name="menutype")
public class MenuType {
   /** @pdOid db21c0b6-3a47-496f-88fb-b77f677b9fa4 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   public int id;
   
   /** @pdRoleInfo migr=no name=Type assc=typeMenuTypeReference mult=1..1 side=A */
   public Type type;
   /** @pdRoleInfo migr=no name=Menu assc=menuMenuTypeRefenrence mult=1..1 side=A */
   public Menu menu;

}
