package com.app.service;

import com.app.model.User;

public interface IUserService {

	public int saveUser(User u);
	public boolean isUserExist(String uname);
	public boolean isUserEmailExist(String email);
	public boolean isUserExistWithUnameAndPwd(String uname,String pwd);
}
