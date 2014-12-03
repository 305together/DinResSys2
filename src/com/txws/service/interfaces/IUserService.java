package com.txws.service.interfaces;


import java.util.List;

import com.txws.model.AddressTable;
import com.txws.model.UserTable;

public interface IUserService {
	UserTable login(UserTable u);
	UserTable loadUser(int id);
	List<String> loadAuthorities(int id);
	void addUser(UserTable user);
	void addAddress(AddressTable ad);
	void delUser(UserTable user);
}
