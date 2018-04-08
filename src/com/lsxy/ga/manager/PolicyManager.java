package com.lsxy.ga.manager;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.Policy;

public interface PolicyManager {
	
	public void addPolicy(Policy p,int courseId,int userId);
	
	public void updatePolicy(Policy p);
	
	public void delPolicy(int id);
	
	public PagerModle findPolicys();
	
	public Policy getPolicyById(int id);
}
