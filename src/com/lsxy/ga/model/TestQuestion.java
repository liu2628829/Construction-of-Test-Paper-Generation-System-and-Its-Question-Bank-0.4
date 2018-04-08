package com.lsxy.ga.model;

import java.util.Date;


/**
 * 
 * @author Administrator
 * @hibernate.class table="T_testquestion"
 */ 
public class TestQuestion {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	//试题的编号
	private int id;

	/**
	 * @hibernate.many-to-one
	 */
	//试题的类型
	private Type type;
	
	/**
	 * @hibernate.property
	 */
	//试题内容
	private String content;
	
	
	/**
	 * @hibernate.property
	 */
	//难度系数
	private double difficulty;
	
	/**
	 * @hibernate.property
	 */
	//区分度
	private double differentiate;

	/**
	 * @hibernate.property
	 */
	//出题次数
	private int count;
	
	/**
	 * @hibernate.property
	 */
	//最近出题时间
	private Date lateTime;
	
	/**
	 * @hibernate.property
	 */
	//建议答题时间
	private int  adviceTime;
	
	/**
	 * @hibernate.property
	 */
	//答案
	private String result;
	
	/**
	 * @hibernate.many-to-one
	 */
	//试题所属知识点
	private KnowledgePoint knowledgePoint;
	
	/**
	 * @hibernate.many-to-one
	 */
	//试题所属小节
	private Section section;
	
	/**
	 * @hibernate.many-to-one
	 */
	//试题所属章节
	private Chapter  chapter ;
	
	/**
	 * @hibernate.many-to-one
	 */
	//试题所属课程
	private Course course;
	/**
	 * @hibernate.property
	 */
	//试题的状态
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public KnowledgePoint getKnowledgePoint() {
		return knowledgePoint;
	}

	public void setKnowledgePoint(KnowledgePoint knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}