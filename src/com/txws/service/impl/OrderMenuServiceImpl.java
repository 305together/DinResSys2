package com.txws.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.OrderMenuTable;
import com.txws.service.interfaces.IOrdersMenuService;
@Service("ordersMenuService")
public class OrderMenuServiceImpl implements IOrdersMenuService {
	@Resource(name = "commonDAO")
	private ICommonDAO commonDAO;
	
	@Override
	public void addOrderMenuTable(OrderMenuTable orderMenuTable) {
		commonDAO.save(orderMenuTable);
	}

	@Override
	public List<OrderMenuTable> loadOrderMenuTablesByOrderId(int orderId) {
		List<OrderMenuTable> list = commonDAO.getObjectsByKey(OrderMenuTable.class, "orderId", String.valueOf(orderId));
		return list;
	}

	@Override
	public void delOrderMenuTablesByOrderId(int orderId) {
		// TODO 自动生成的方法存根
		
	}

}
