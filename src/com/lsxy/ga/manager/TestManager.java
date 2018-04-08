package com.lsxy.ga.manager;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.Test;

public interface TestManager{
	
	public void addTest(Test t,int userId);
	public PagerModle findTests();	
	public Test getTestById(int id);
	public void delTest(int id);
}
