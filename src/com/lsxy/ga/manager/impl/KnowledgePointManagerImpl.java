package com.lsxy.ga.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.KnowledgePointManager;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Dwrmodle;
import com.lsxy.ga.model.KnowledgePoint;
import com.lsxy.ga.model.Section;

public class KnowledgePointManagerImpl extends AbstractManager implements
		KnowledgePointManager {

	@Override
	public void addPoint(KnowledgePoint kp, int sectionId) {
		
		kp.setCt((Section)getHibernateTemplate().load(Section.class,sectionId));
		
		getHibernateTemplate().save(kp);
		
		

	}


	public void delPoint(int KPId) {
		
		KnowledgePoint kp = (KnowledgePoint)getHibernateTemplate().load(KnowledgePoint.class, KPId);
		
		getHibernateTemplate().delete(kp);
	}


	public PagerModle findPoints(int sectionId) {
		
		return searchPaginated("from KnowledgePoint k where k.ct ="+sectionId);
	}


	@Override
	public List<Dwrmodle> findKnowledgePointScript(int sectionId) {

		List<Dwrmodle>  dwr = new ArrayList<Dwrmodle>();
		List<KnowledgePoint> kps = getSession().createQuery("from KnowledgePoint kp where kp.ct="+sectionId).list();
		for(int i=0;i<kps.size();i++){
			Dwrmodle dm = new Dwrmodle();
			dm.setId(kps.get(i).getId());
			dm.setName(kps.get(i).getName());
			dwr.add(dm);
		}
		return  dwr;
	}


	@Override
	public KnowledgePoint getKnowledgePointById(int id) {
		KnowledgePoint kp =(KnowledgePoint)getHibernateTemplate().load(KnowledgePoint.class, id);
		return kp;
	}

}
