package com.lsxy.ga.manager;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.User;

public interface UserManager {

	public void loginUser(User u);

	public void addUser(User u);
	
	public void delUser(int userId);
	
	public void updateUser(User user);
	
	public User getById(int UserId);
	
	public PagerModle findUsers();
}
