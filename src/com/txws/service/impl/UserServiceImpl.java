package com.txws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.AddressTable;
import com.txws.model.UserTable;
import com.txws.service.interfaces.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource(name = "commonDAO")
	private ICommonDAO commonDAO;

	@Override
	public UserTable login(UserTable u) {
		List<UserTable> users = commonDAO.getObjectsByKey(
				UserTable.class, "name", u.getName());
		if (users.size() != 0) {
			for (UserTable userTable : users) {
				if (u.getPassword().equals(users.get(0).getPassword())){
					System.out.println(u.getPassword());
					return userTable;
					}
			}
		}
		return null;
	}
	
	@Override
	public UserTable loadUser(int id){
		UserTable user = commonDAO.getObject(UserTable.class, id);
		return user;
	}
	
	@Override
	public List<String> loadAuthorities(int id) {
		return new ArrayList<String>();
	}
	
	@Override
	public boolean addUser(UserTable user){
		List<UserTable> list = commonDAO.getObjectsByKey(UserTable.class, "name", user.getName());
		if(list.size() == 0) {
			commonDAO.save(user);
			return true;
		}else{
			return false;
		}
	}
	
	public void addAddress(AddressTable ad){
		commonDAO.save(ad);
	}
	
	public void delUser(UserTable user){
		commonDAO.delete(user);
	}
}
