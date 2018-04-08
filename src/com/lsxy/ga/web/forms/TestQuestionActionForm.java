package com.lsxy.ga.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Course;
import com.lsxy.ga.model.KnowledgePoint;
import com.lsxy.ga.model.Section;

public class TestQuestionActionForm extends ActionForm {
	
	private int id;

	//试题的类型
	private int typeId;
	
	//试题内容
	private String content;
	
	//难度系数
	private double difficulty;

	//区分度
	private double differentiate;
	
	//出题频率
	private int count;
	
	//最近出题时间
	private Date lateTime;
	
	//建议答题时间
	private int  adviceTime;

	//答案
	private String result;

	//试题所属知识点
	private int knowledgePointId;
	

	//试题所属小节
	private int sectionId;
	

	//试题所属章节
	private int  chapterId;
	
	//试题所属课程
	private int courseId;
	//试题状态
	private int state;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public double getDifferentiate() {
		return differentiate;
	}

	public void setDifferentiate(double differentiate) {
		this.differentiate = differentiate;
	}



	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getLateTime() {
		return lateTime;
	}

	public void setLateTime(Date lateTime) {
		this.lateTime = lateTime;
	}

	public int getAdviceTime() {
		return adviceTime;
	}

	public void setAdviceTime(int adviceTime) {
		this.adviceTime = adviceTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getKnowledgePointId() {
		return knowledgePointId;
	}

	public void setKnowledgePointId(int knowledgePointId) {
		this.knowledgePointId = knowledgePointId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
