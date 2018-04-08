package com.lsxy.ga.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;


import com.lsxy.ga.manager.SystemException;
import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.ChapterManager;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Course;
import com.lsxy.ga.model.Dwrmodle;

public class ChapterManagerImpl extends AbstractManager implements
		ChapterManager {


	public void addChapter(Chapter cp,int courseId) {
		
		cp.setCs(
				(Course)getHibernateTemplate().load(Course.class, courseId)
			);
		getHibernateTemplate().save(cp);
	}


	@Override
	public void delChapter(int chapterId) {
		
		int count = ((Long)getSession().
				createQuery("select count(*) from Section  where chapterId="+chapterId).
				uniqueResult()).intValue();
	    if(count>0){
		throw new SystemException("下面有小节，不允许删除");
	}
		Chapter cp = (Chapter)getHibernateTemplate().load(Chapter.class, chapterId);
		getHibernateTemplate().delete(cp);
	}


	public PagerModle findChapters(int courseId) {
		
		return searchPaginated("from Chapter where courseId ="+courseId);
	}
	
	


	public void updateChapter(int chapterId) {
		Chapter cp = (Chapter)getHibernateTemplate().load(Chapter.class, chapterId);
		getHibernateTemplate().update(cp);

	}


	@Override
	public List<Dwrmodle> findChapterScript(int cs) {
		
		List<Dwrmodle>  dwr = new ArrayList<Dwrmodle>();
		List<Chapter> cps = getSession().createQuery("from Chapter  where courseId="+cs).list();
		for(int i=0;i<cps.size();i++){
			Dwrmodle dm = new Dwrmodle();
			dm.setId(cps.get(i).getId());
			dm.setName(cps.get(i).getName());
			dwr.add(dm);
		}
		return  dwr;
	}


	@Override
	public Chapter getChapterById(int id) {
		Chapter cp = (Chapter)getHibernateTemplate().load(Chapter.class, id);
		return cp;
	}



}
