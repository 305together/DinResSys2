package com.txws.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="typeName")
	private java.lang.String typeName;
	@OneToMany(mappedBy="menu",cascade={CascadeType.ALL})
	private java.util.Collection<Menu> menu;

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
	
	public java.util.Collection<Menu> getMenu() {
		if (menu == null)
			menu = new java.util.HashSet<Menu>();
		return menu;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Iterator getIteratorMenu() {
		if (menu == null)
			menu = new java.util.HashSet<Menu>();
		return menu.iterator();
	}

	@SuppressWarnings("rawtypes")
	public void setMenu(java.util.Collection<Menu> newMenu) {
		removeAllMenu();
		for (java.util.Iterator iter = newMenu.iterator(); iter.hasNext();)
			addMenu((Menu) iter.next());
	}

	public void addMenu(Menu newMenu) {
		if (newMenu == null)
			return;
		if (this.menu == null)
			this.menu = new java.util.HashSet<Menu>();
		if (!this.menu.contains(newMenu)) {
			this.menu.add(newMenu);
			newMenu.setType(this);
		}
	}

	public void removeMenu(Menu oldMenu) {
		if (oldMenu == null)
			return;
		if (this.menu != null)
			if (this.menu.contains(oldMenu)) {
				this.menu.remove(oldMenu);
				oldMenu.setType((Type) null);
			}
	}

	@SuppressWarnings("rawtypes")
	public void removeAllMenu() {
		if (menu != null) {
			Menu oldMenu;
			for (java.util.Iterator iter = getIteratorMenu(); iter
					.hasNext();) {
				oldMenu = (Menu) iter.next();
				iter.remove();
				oldMenu.setType((Type) null);
			}
		}
	}
}