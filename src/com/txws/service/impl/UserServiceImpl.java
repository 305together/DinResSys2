package com.txws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txws.dao.interfaces.ICommonDAO;
import com.txws.model.UserTable;
import com.txws.service.interfaces.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource(name = "commonDAO")
	private ICommonDAO commonDAO;

	public UserTable login(UserTable u) {
		List<UserTable> users = (List<UserTable>) commonDAO.getObjectsByKey(
				UserTable.class, "userName", u.getUserName());
		if (users.size() != 0) {
			for (UserTable userTable : users) {
				if (u.getUserPw().equals(users.get(0).getUserPw()))
					return userTable;
			}
		}
		return null;
	}
	
	public UserTable loadUser(int id){
		UserTable userTable = commonDAO.getObject(UserTable.class, id);
		return userTable;
	}
	
	public List<String> loadAuthorities(int id) {
		return new ArrayList<String>();
	}
}
