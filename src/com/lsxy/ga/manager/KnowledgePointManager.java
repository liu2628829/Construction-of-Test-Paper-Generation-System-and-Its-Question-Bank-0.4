package com.lsxy.ga.manager;

import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.Dwrmodle;
import com.lsxy.ga.model.KnowledgePoint;

public interface KnowledgePointManager {
	
	public void addPoint(KnowledgePoint kp,int chapterId);
	
	public void delPoint(int KPId);
	
	public PagerModle findPoints(int ChapterId);
	
	public List<Dwrmodle> findKnowledgePointScript(int sectionId);
	
	public KnowledgePoint getKnowledgePointById(int id);
}
