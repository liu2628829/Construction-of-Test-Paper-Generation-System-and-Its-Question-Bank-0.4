package com.lsxy.ga.manager.impl;


import java.util.ArrayList;
import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.SectionManager;
import com.lsxy.ga.manager.SystemException;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Dwrmodle;
import com.lsxy.ga.model.Section;

public class SectionManagerImpl extends AbstractManager
implements SectionManager {

	@Override
	public void addSection(Section st, int chapterId) {
		st.setCp((Chapter)getHibernateTemplate().load(Chapter.class, chapterId));
		getHibernateTemplate().save(st);
	}

	@Override
	public void delSection(int sectionId) {
		
		int count = ((Long)getSession().
				createQuery("select count(*) from KnowledgePoint  where sectionId="+sectionId).
				uniqueResult()).intValue();
	    if(count>0){
		throw new SystemException("下面有知识点，不允许删除");
	}
		Section st = (Section)getHibernateTemplate().load(Section.class, sectionId);
		
		getHibernateTemplate().delete(st);
	}

	@Override
	public PagerModle findSections(int chapterId) {
		
		return searchPaginated("from Section where chapterId ="+chapterId);
	}
	
	public List<Dwrmodle> findSectionScript(int chapterId) {
		List<Dwrmodle>  dwr = new ArrayList<Dwrmodle>();
		List<Section> scs = getSession().createQuery("from Section  where chapterId="+chapterId).list();
		for(int i=0;i<scs.size();i++){
			Dwrmodle dm = new Dwrmodle();
			dm.setId(scs.get(i).getId());
			dm.setName(scs.get(i).getName());
			dwr.add(dm);
		}
		return  dwr;
	}

	@Override
	public Section getSectionById(int id) {
		Section se = (Section)getHibernateTemplate().load(Section.class, id);
		return se;
	}

}
