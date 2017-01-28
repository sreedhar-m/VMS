package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate ht;

	public int saveUser(User u){
		return (Integer) ht.save(u);
	}

	public boolean isUserExist(String uname) {
		String hql="from "+User.class.getName()+" where userName=?";
		List<User> l=ht.find(hql, uname);

		return l.size()>0;
	}


	public boolean isUserExistWithUnameAndPwd(String uname, String pwd) {
		return ht.find("from "+User.class.getName()+" where userEmail=? and userPassword=?",uname,pwd).size()>0;
	}

	public boolean isUserEmailExist(String email) {
		String hql="from "+User.class.getName()+" where userEmail=?";
		List<User> l=ht.find(hql, email);

		return l.size()>0;
	}


}
