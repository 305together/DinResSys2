package com.txws.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public List<MenuTable> getAllMenu() {
		List<MenuTable> list = new ArrayList<>();
		list = commonDAO.getObjects("MenuTable");
		return list;
	}
	
	
}
