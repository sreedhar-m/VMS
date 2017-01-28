package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CoDecUtil;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;
	@Autowired
	private CoDecUtil cUtil;
	public int saveUser(User u) {
		String encPwd=cUtil.doEncode(u.getUserPassword());
		u.setUserPassword(encPwd);
		return dao.saveUser(u);
	}

	public boolean isUserExist(String uname) {
		return dao.isUserExist(uname);
	}

	public boolean isUserExistWithUnameAndPwd(String uname, String pwd) {
		return dao.isUserExistWithUnameAndPwd(uname, pwd);
	}

	public boolean isUserEmailExist(String email) {
		return dao.isUserEmailExist(email);
	}

}
