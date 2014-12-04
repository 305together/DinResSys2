package com.txws.service.interfaces;

import java.util.List;
import java.util.Map;

import com.txws.model.AppraiseTable;
import com.txws.model.MenuTable;
import com.txws.model.TypeTable;


public interface IMenuService {
	List<TypeTable> getMenuTypes();
	List<TypeTable> getMenuByTypes(String typeId);
	List<MenuTable> getAllMenu();
	List<String> getActivityMenuImg();
}
