package com.lsxy.ga.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.lsxy.ga.model.User;

public class TestActionForm extends ActionForm {
	
	private int id;//试卷编号
	
	private String name;//试卷名称

	private String types;//试卷题型编号

	private String testQuestions;//试卷题目编号

	private int userId;//出卷人

	private Date date;//出卷时间

	private int mark;//试卷总分
	
	private int countTime;//考试总时间
	
	public int getCountTime() {
		return countTime;
	}

	public void setCountTime(int countTime) {
		this.countTime = countTime;
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
}
