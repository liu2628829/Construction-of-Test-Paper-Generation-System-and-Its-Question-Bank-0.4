package com.lsxy.ga.manager.impl;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.SystemException;
import com.lsxy.ga.manager.UserManager;
import com.lsxy.ga.model.User;

import java.util.List;

public class UserManagerImpl extends AbstractManager implements UserManager {

	/**
	 *
	 * @param u
	 */
	@Override
	public void loginUser(User u) {
		List<User> user = findUsers().getDatas();
		for(int i=0;i<user.size();i++){
			if(!user.get(i).getUserName().equals(u.getUserName()) && user.get(i).getPassword().equals(u.getPassword()) ) {

					throw new SystemException("登录失败");
			}
		}


	}

	@Override
	public void addUser(User u) {
		List<User> user = findUsers().getDatas();
		for(int i=0;i<user.size();i++){
			if(user.get(i).getUserName().equals(u.getUserName())){
				throw new SystemException("该用户名已经存在，不允许添加");
			}
		}
		getHibernateTemplate().save(u);

	}

	@Override
	public void delUser(int userId) {
		
		User u = (User)getHibernateTemplate().load(User.class,userId);
		getHibernateTemplate().delete(u);

	}

	@Override
	public User getById(int userId) {
		
		return (User)getHibernateTemplate().load(User.class, userId);	
	}

	
	public PagerModle findUsers() {
		// TODO Auto-generated method stub
		return searchPaginated("from User");
	}

	@Override
	public void updateUser(User user) {
		
		getHibernateTemplate().update(user);

	}

}
