package com.txws.service.interfaces;

import java.util.List;

import com.txws.model.MenuTable;
import com.txws.model.TypeTable;


public interface IMenuService {
	List<TypeTable> getMenuTypes();
	List<TypeTable> getMenuByTypes(String typeId);
	List<MenuTable> getAllMenu();
}