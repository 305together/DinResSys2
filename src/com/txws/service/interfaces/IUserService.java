package com.txws.service.interfaces;


import java.util.List;

import com.txws.model.Address;
import com.txws.model.User;

public interface IUserService {
	User login(User u);
	User loadUser(int id);
	List<String> loadAuthorities(int id);
	void addUser(User user);
	void addAddress(Address ad);
	void delUser(User user);
}
