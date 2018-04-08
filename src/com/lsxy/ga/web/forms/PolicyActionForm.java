package com.lsxy.ga.web.forms;

import org.apache.struts.action.ActionForm;


public class PolicyActionForm extends ActionForm {
	private int id;//策略编号
	
	private String name;//策略名称
	
	private int  courseId;//试题所属课程
	
	private int mark;//试卷总分
	
	private int time;//考试时间
	
	private int count;//试题的总数
	
	private double difficulty;//试卷难度
	
	private double differentiate;//试卷区分度
	
	private double exposure;//试卷的曝光度
	
	private String chapterIdInverse;//所有章的id字符串
	
	private String sections;//所有小节的字符串
	
	private String knowledgePointIds;//所有小节的字符串
	
	private String typeQuantityMark;//所有试题类型和题型分数
	
	private int userId;//组卷用户

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	

	public String getChapterIdInverse() {
		return chapterIdInverse;
	}

	public void setChapterIdInverse(String chapterIdInverse) {
		this.chapterIdInverse = chapterIdInverse;
	}

	public String getSections() {
		return sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public String getKnowledgePointIds() {
		return knowledgePointIds;
	}

	public void setKnowledgePointIds(String knowledgePointIds) {
		this.knowledgePointIds = knowledgePointIds;
	}

	public String getTypeQuantityMark() {
		return typeQuantityMark;
	}

	public void setTypeQuantityMark(String typeQuantityMark) {
		this.typeQuantityMark = typeQuantityMark;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getExposure() {
		return exposure;
	}

	public void setExposure(double exposure) {
		this.exposure = exposure;
	}



}
