package com.txws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.Address;
import com.txws.model.User;
import com.txws.service.interfaces.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource(name = "commonDAO")
	private ICommonDAO commonDAO;

	@Override
	public User login(User u) {
		List<User> users = commonDAO.getObjectsByKey(
				User.class, "userName", u.getName());
		if (users.size() != 0) {
			for (User userTable : users) {
				if (u.getPassword().equals(users.get(0).getPassword()))
					return userTable;
			}
		}
		return null;
	}
	
	@Override
	public User loadUser(int id){
		User user = commonDAO.getObject(User.class, id);
		return user;
	}
	
	@Override
	public List<String> loadAuthorities(int id) {
		return new ArrayList<String>();
	}
	
	@Override
	public void addUser(User user){
		commonDAO.save(user);
	}
	
	public void addAddress(Address ad){
		commonDAO.save(ad);
	}
	
	public void delUser(User user){
		commonDAO.delete(user);
	}
}
