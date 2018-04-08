package com.lsxy.ga.manager.impl;

import java.util.Date;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.SectionManager;
import com.lsxy.ga.manager.TestManager;
import com.lsxy.ga.model.Test;
import com.lsxy.ga.model.User;

public class TestManagerImpl extends AbstractManager
implements TestManager{


	public void addTest(Test t, int userId) {
		User u= (User)getHibernateTemplate().load(User.class, 1);
		t.setUser(u);
		t.setDate(new Date(System.currentTimeMillis()));
		getHibernateTemplate().save(t);
	}

	@Override
	public PagerModle findTests() {

		return searchPaginated("from Test");
	}

	@Override
	public Test getTestById(int id) {
		Test t = (Test)getHibernateTemplate().load(Test.class, id);
		return t;
	}

	@Override
	public void delTest(int id) {
		Test t = (Test)getHibernateTemplate().load(Test.class, id);
		getHibernateTemplate().delete(t);
		
	}

}
