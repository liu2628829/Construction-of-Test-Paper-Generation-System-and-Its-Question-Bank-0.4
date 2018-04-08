package com.lsxy.ga.manager;

import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.Dwrmodle;
import com.lsxy.ga.model.Section;

public interface SectionManager {
	
	public void addSection(Section st,int chapterId );
	
	public void delSection(int sectionId);
	
	public PagerModle findSections(int chapterId);
	
	public List<Dwrmodle> findSectionScript(int chapterId);
	
	public Section getSectionById(int id);
}
