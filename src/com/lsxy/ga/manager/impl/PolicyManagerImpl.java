package com.lsxy.ga.manager.impl;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.PolicyManager;
import com.lsxy.ga.model.Course;
import com.lsxy.ga.model.Policy;
import com.lsxy.ga.model.User;

public class PolicyManagerImpl extends AbstractManager implements PolicyManager {


	public void addPolicy(Policy p,int courseId,int userId) {
		p.setCourse((Course)getHibernateTemplate().load(Course.class, courseId));
		p.setUser((User)getHibernateTemplate().load(User.class,1));
		getHibernateTemplate().save(p);
		
	}

	public void delPolicy(int id) {
		
		Policy p = (Policy)getHibernateTemplate().load(Policy.class,id);
		getHibernateTemplate().delete(p);
	}


	public PagerModle findPolicys() {
		return searchPaginated("from Policy");
	}

	@Override
	public void updatePolicy(Policy p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Policy getPolicyById(int id) {
		Policy p = (Policy)getHibernateTemplate().load(Policy.class, id);
		return p;
	}
	
}
