package com.txws.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.MenuTable;
import com.txws.model.OrderMenuTable;
import com.txws.model.TypeTable;
import com.txws.service.interfaces.IMenuService;
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
	@Resource(name = "commonDAO")
	private ICommonDAO commonDAO;

	@Override
	public List<TypeTable> getMenuTypes() {
		List<TypeTable> list = new ArrayList<>();
		list = commonDAO.getObjects("TypeTable");
		return list;
	}

	@Override
	public List<TypeTable> getMenuByTypes(String typeId) {
		List<TypeTable> list = new ArrayList<>();
		list = commonDAO.getObjectsByKey(TypeTable.class, "typeId", typeId);
		return list;
	}

	@Override
	public List<Object> getAllMenu() {
		List<MenuTable> list = new ArrayList<>();
		list = commonDAO.getObjects("MenuTable");
		List<Object> dataList = new ArrayList<>();
		for (MenuTable menuTable : list) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("id", menuTable.getId());
			dataMap.put("item", menuTable.getItem());
			dataMap.put("price", menuTable.getPrice());
			dataMap.put("saleNum", menuTable.getOrderNum());
			dataMap.put("type", menuTable.getTypeTable().getTypeName());
			dataList.add(dataMap);
		}
		return dataList;
	}

	@Override
	public List<? super String> getActivityMenuImg() {
		List<String> list = commonDAO.getPartialObjects("select picture from "
				+ "MenuTable where isInActivity = 1", 0, 4);
		return list;
	}

	@Override
	public MenuTable getMenuById(int id) {
		MenuTable menu = commonDAO.getObject(MenuTable.class, id);
		return menu;
	}

	@Override
	public List<MenuTable> getMenuTablesByOrderId(int orderId) {
		List<MenuTable> menuTables = new ArrayList<>();
		List<OrderMenuTable> orderMenuTables = commonDAO.getObjectsByKey(OrderMenuTable.class, "orderId", String.valueOf(orderId));
		for (OrderMenuTable orderMenuTable : orderMenuTables) {
			menuTables.add(commonDAO.getObject(MenuTable.class, orderMenuTable.getMenuId()));
		}
		return menuTables;
	}

	@Override
	public void deleteMenu(MenuTable menuTable) {
		System.out.println(menuTable.getId() + "............");
		commonDAO.delete(menuTable);
	}

	@Override
	public void addMenu(MenuTable menuTable, int typeId) {
		TypeTable type = commonDAO.getObject(TypeTable.class, typeId);
		menuTable.setTypeTable(type);
		commonDAO.save(menuTable);
	}

	@Override
	public void updateMenu(MenuTable menuTable) {
		commonDAO.update(menuTable);
	}

	@Override
	public void removeActivity(int activityId) {
		List<MenuTable> menuList = commonDAO.getObjectsByKey(MenuTable.class, "activityId", String.valueOf(activityId));
		for (MenuTable menuTable : menuList) {
			menuTable.setActivityTable(null);
			menuTable.setIsInActivity(0);
		}
	}

}
