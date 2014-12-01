package com.txws.model;

/***********************************************************************
 * Module:  Type.java
 * Author:  Administrator
 * Purpose: Defines the Class Type
 ***********************************************************************/

/** @pdOid d04de217-26de-418b-9eeb-0e49868e6110 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type {
	/** @pdOid 1535f0d1-7c29-457a-86e3-3a9377e129f9 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	/** @pdOid 20b20792-abbd-4bd9-9e41-6a0b49012af3 */
	@Column(name="typeName")
	public java.lang.String typeName;

	/** @pdRoleInfo migr=no name=MenuType assc=typeMenuTypeReference mult=1..1 */
	//public MenuType menuType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.lang.String getTypeName() {
		return typeName;
	}

	public void setTypeName(java.lang.String typeName) {
		this.typeName = typeName;
	}

/*	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}*/

}