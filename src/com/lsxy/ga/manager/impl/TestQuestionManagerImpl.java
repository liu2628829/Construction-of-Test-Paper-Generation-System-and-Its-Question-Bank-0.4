package com.lsxy.ga.manager.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.TestQuestionManager;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Course;
import com.lsxy.ga.model.KnowledgePoint;
import com.lsxy.ga.model.Section;
import com.lsxy.ga.model.TestQuestion;
import com.lsxy.ga.model.Type;

public class TestQuestionManagerImpl extends AbstractManager implements
		TestQuestionManager {

	public void addTestQuestion(TestQuestion tq, int typeId,int courseId, int chapterId,
			int sectionId, int knowledgePointId) {	
System.out.println("检测参数====》》》"+typeId);
		Course  cs = (Course)getHibernateTemplate().load(Course.class, courseId);
		Chapter  cp = (Chapter)getHibernateTemplate().load(Chapter.class, chapterId);
		Section  sc = (Section)getHibernateTemplate().load(Section.class,sectionId);
		KnowledgePoint  kp = (KnowledgePoint)getHibernateTemplate().load(KnowledgePoint.class, knowledgePointId);
		Type t =(Type)getHibernateTemplate().load(Type.class, typeId); 
		
		 tq.setCourse(cs);
		 tq.setChapter(cp);
		 tq.setSection(sc);
		 tq.setKnowledgePoint(kp);
		 tq.setType(t);
		getHibernateTemplate().save(tq);
		

	}


	public void delTestQuestion(int testQuestionId) {
		
		TestQuestion tq = (TestQuestion)getHibernateTemplate().load(TestQuestion.class, testQuestionId);
		
		getHibernateTemplate().delete(tq);

	}
	
     public PagerModle findTestQuestions() {
		
		return searchPaginated("from TestQuestion tq");
	}

	public PagerModle findTestQuestions(int courseId, int chapterId,
			int sectionId,int knowledgePointId) {
		String hql = "from TestQuestion tq";
		if(courseId!=0){
			hql += " where tq.course="+courseId;
		}
		if(chapterId!=0){
			hql +=" and tq.chapter="+chapterId;
		}
		if(sectionId!=0){
			hql +=" and tq.section="+sectionId;
		}
		if(knowledgePointId!=0){
			hql +=" and tq.knowledgePoint="+knowledgePointId;
		}
System.out.print("sql语句检测===》"+hql);
		return searchPaginated(hql);
	}

	

	
	public void updateTestQuestion(TestQuestion tq) {

		getHibernateTemplate().update(tq);

	}


	@Override
	public TestQuestion getTestQuestionById(int id) {
		TestQuestion tq =(TestQuestion)getHibernateTemplate().load(TestQuestion.class, id);
		return tq;
	}


	@Override
	public TestQuestion getTestQuestionByDate(Date d) {
		String hql = "from TestQuestion t where t.lateTime="+"'"+new Timestamp(d.getTime())+"'";
		TestQuestion tq = (TestQuestion)getSession().createQuery(hql).uniqueResult();
		return tq;
	}


	@Override
	public void updateDwrState(int id, boolean state) {
		TestQuestion tq = (TestQuestion)getHibernateTemplate().load(TestQuestion.class, id);
		if(state){
			tq.setState(1);
		}else{
			tq.setState(0);
		}
		getHibernateTemplate().update(tq);
	}


	@Override
	public List getQuestionsByIds(int[] knowledgePointIds,int[] typeIds) {
		
		
		String hql ="from TestQuestion t ";
		
		if(knowledgePointIds!=null){
			hql += "where t.knowledgePoint in (";
			for(int i=0;i<knowledgePointIds.length;i++){
				
				if(i==knowledgePointIds.length-1){
					hql += knowledgePointIds[i]+")";
				}else{
					hql+=knowledgePointIds[i]+",";
				}
			}
		}else{
			hql += "where t.knowledgePoint in (0)";
		}
		if(typeIds!=null){
			hql += "and t.type in (";
			for(int i=0;i<typeIds.length;i++){
				if(i==typeIds.length-1){
					hql += typeIds[i]+")";
				}else{
					hql += typeIds[i]+",";
				}
			}
		}else{
			hql += " and t.type in (0)";
		}
		
System.out.print("查询语句打印"+hql);

		List tqList = getSession().createQuery(hql).list();
		
		return tqList;
	}

}
