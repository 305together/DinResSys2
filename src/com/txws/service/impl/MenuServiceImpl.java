package com.txws.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.MenuTable;
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

}
