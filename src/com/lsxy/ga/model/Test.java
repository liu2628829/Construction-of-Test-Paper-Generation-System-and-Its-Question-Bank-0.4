package com.lsxy.ga.model;

import java.util.Date;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_test"
 */ 
public class Test {
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;//试卷编号
	/**
	 * @hibernate.property
	 */
	private String name;//试卷名称
	/**
	 * @hibernate.property
	 */
	private String types;//试卷题型编号及各题分数
	/**
	 * @hibernate.property
	 */
	private String testQuestions;//试卷题目编号
	/**
	 * @hibernate.many-to-one
	 */
	private User user;//出卷人
	/**
	 * @hibernate.property
	 */
	private Date date;//出卷时间
	/**
	 * @hibernate.property
	 */
	private int mark;//试卷总分
	/**
	 * @hibernate.property
	 */
	private int countTime;
	
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
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(String testQuestions) {
		this.testQuestions = testQuestions;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getCountTime() {
		return countTime;
	}
	public void setCountTime(int countTime) {
		this.countTime = countTime;
	}
	
	
}
