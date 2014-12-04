package com.txws.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.AppraiseTable;
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
	public List<MenuTable> getAllMenu() {
		List<MenuTable> list = new ArrayList<>();
		list = commonDAO.getObjects("MenuTable");
		return list;
	}

	@Override
	public List<String> getActivityMenuImg() {
		List<String> list = commonDAO.getPartialObjects("select picture from "
				+ "MenuTable where isInActivity = 1", 0, 4);
		return list;
	}

}
