package com.lsxy.ga.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.GaModleManager;
import com.lsxy.ga.model.Course;
import com.lsxy.ga.model.GaModle;

public class GaModleManagerImpl extends AbstractManager implements
		GaModleManager {
	
	
	public PagerModle findGaModel(){ 
		return searchPaginated("from GaModle");
	}

	@Override
	public void updateGaModle(GaModle ga) {
		getHibernateTemplate().update(ga);
	}

	@Override
	public void addGaModle(GaModle ga) {
		getHibernateTemplate().save(ga);
		
	}

	@Override
	public void delGaModle(int id) {
		GaModle ga =(GaModle)getHibernateTemplate().load(GaModle.class, id);
		getHibernateTemplate().delete(ga);
		
	}

	@Override
	public GaModle findGamodleById(int id) {
		GaModle ga =(GaModle)getHibernateTemplate().load(GaModle.class, id);
		return ga;
	}

	@Override
	public void updateState(int id) {
		List<GaModle> gas = new ArrayList<GaModle>();
		
		Query query = getSession().createQuery("from GaModle");
		gas = query.list();
		for(int i=0;i<gas.size();i++){
			if(gas.get(i).isState()==true){
				GaModle ga = (GaModle)getHibernateTemplate().load(GaModle.class, gas.get(i).getId());
				ga.setState(false);
			}
		}
		
		GaModle ga2 = (GaModle)getHibernateTemplate().load(GaModle.class, id);
		ga2.setState(true);
	}

	@Override
	public GaModle getGamodleByState() {
		Query query = getSession().createQuery("from GaModle g where g.state=1");
		GaModle gm= (GaModle)query.uniqueResult();
		return gm;
	}

}
