package com.txws.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.config.ParentPackage;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.txws.model.AddressTable;
import com.txws.model.MenuTable;
import com.txws.model.OrderMenuTable;
import com.txws.model.OrdersTable;
import com.txws.model.UserTable;
import com.txws.service.interfaces.IAddressService;
import com.txws.service.interfaces.IMenuService;
import com.txws.service.interfaces.IOrdersMenuService;
import com.txws.service.interfaces.IOrdersService;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4909854934245282225L;

	private Object data = new Object();
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private List<Object> dataList = new ArrayList<>();
	private String phone;
	private int addressID;
	private String remark;
	private Map<Integer,Integer> menus;

	@Resource(name = "ordersService")
	private IOrdersService ordersService;
	@Resource(name = "addressService")
	private IAddressService addressService;
	@Resource(name = "menuService")
	private IMenuService menuService;
	@Resource(name = "ordersMenuService")
	private IOrdersMenuService ordersMenuService;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Map<Integer,Integer> getMenus() {
		return menus;
	}

	public void setMenus(Map<Integer,Integer> menus) {
		this.menus = menus;
	}

	// TODO 发货时ordernum++,menus为键值对
	public String commitOrderResult() {
		dataMap.clear();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		OrdersTable ordersTable = new OrdersTable();
		int priceTotal = 0;

		for (Integer mapKey : menus.keySet()) {
			MenuTable menuTable = menuService.getMenuById(mapKey);
			priceTotal += (menus.get(mapKey) * menuTable.getPrice());
			menuTable.setOrderNum(menuTable.getOrderNum()+1);
			menuService.updateMenu(menuTable);
		}
		AddressTable addressTable = addressService.loadAddress(addressID);
		ordersTable.setUserTable((UserTable) session.get("user"));
		ordersTable.setPhone(phone);
		ordersTable.setCreateTime(new Date());
		ordersTable.setPrice(priceTotal);
		ordersTable.setMessage(remark);
		ordersTable.setStatus("出单");
		ordersTable.setAddressTable(addressTable);

		//保存order
		try {
			ordersTable = ordersService.addOrder(ordersTable);
			System.out.println("/////////////////");
			for (Integer mapKey : menus.keySet()) {
				OrderMenuTable orderMenuTable = new OrderMenuTable();
				orderMenuTable.setMenuId(mapKey);
				orderMenuTable.setNum(menus.get(mapKey));
				orderMenuTable.setOrderId(ordersTable.getId());
				ordersMenuService.addOrderMenuTable(orderMenuTable);
			}
			System.out.println("................");
		} catch (Exception e) {
			dataMap.put("status", 2);
			dataMap.put("status2", menus);
			data = dataMap;
			return SUCCESS;
		}
		
		dataMap.put("status", 1);
		dataMap.put("status2", menus);
		data = dataMap;

		return SUCCESS;
	}

	//OK
	public String getAllOrder() {
		dataMap.clear();
		dataList.clear();
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");

		UserTable user = (UserTable) session.get("user");
		List<OrdersTable> ordersTables = ordersService.loadAllOrdersByUser(user
				.getId());

		for (OrdersTable ordersTable : ordersTables) {
			Map<String, Object> tempMap = new HashMap<>();
			List<Map<String, Object>> temp1 = new ArrayList<>();
			tempMap.put("id", ordersTable.getId());
			tempMap.put("date", formatter.format(ordersTable.getCreateTime()));
			tempMap.put("status", ordersTable.getStatus());
			List<MenuTable> menuTables = menuService
					.getMenuTablesByOrderId(ordersTable.getId());
			for (MenuTable menuTable : menuTables) {
				Map<String, Object> temp = new HashMap<>();
				temp.put("id", menuTable.getId());
				temp.put("item", menuTable.getItem());
				temp.put("price", menuTable.getPrice());//乘上数量
				temp.put("saleNum", menuTable.getOrderNum());
				temp.put("type", menuTable.getTypeTable().getTypeName());
				temp1.add(temp);
			}
			tempMap.put("menus", temp1);
			dataList.add(tempMap);
		}
		dataMap.put("orders", dataList);
		data = dataMap;
		return SUCCESS;
	}
	
}
