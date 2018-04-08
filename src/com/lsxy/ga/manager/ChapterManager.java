package com.lsxy.ga.manager;



import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Dwrmodle;

public interface ChapterManager {
	
	
	public void addChapter(Chapter cp,int courseId);
	
	public void updateChapter(int chapterId);
	
	public void delChapter(int chapterId);
	
	public PagerModle findChapters(int courseId);
	
	public List<Dwrmodle> findChapterScript(int CourseId);
 	
	public Chapter getChapterById(int id);
}
