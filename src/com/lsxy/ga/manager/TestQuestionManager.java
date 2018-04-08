package com.lsxy.ga.manager;

import java.util.Date;
import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.TestQuestion;

public interface TestQuestionManager {
	
	//添加试题
	public void addTestQuestion(TestQuestion tq,int typeId,int courseId,int chapterId,int sectionId,int knowledgePointId);
	
	//删除试题
	public void delTestQuestion(int testQuestionId);
	
	//更新试题
	public void updateTestQuestion(TestQuestion tq);
	
	public TestQuestion getTestQuestionById(int id);
	
	public TestQuestion getTestQuestionByDate(Date d);
	
	public void updateDwrState(int id,boolean state);
	//试题查找方法
	public PagerModle findTestQuestions();
	public PagerModle findTestQuestions(int courseId,int chapterId,int sectionId,int knowledgePointId);
	public List getQuestionsByIds(int[] knowledgePointIds,int[] typesIds);
}
