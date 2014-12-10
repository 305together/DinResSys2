package com.txws.service.interfaces;

import java.util.List;

import com.txws.model.MenuTable;
import com.txws.model.TypeTable;


public interface IMenuService {
	List<TypeTable> getMenuTypes();
	List<TypeTable> getMenuByTypes(String typeId);
	List<Object> getAllMenu();
	List<? super String> getActivityMenuImg();
	MenuTable getMenuById(int id);
	List<MenuTable> getMenuTablesByOrderId(int orderId);
	void deleteMenu(MenuTable menuTable);
	void addMenu(MenuTable menuTable, int typeId);
	void updateMenu(MenuTable menuTable);
}
