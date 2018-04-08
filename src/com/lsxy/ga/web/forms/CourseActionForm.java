package com.lsxy.ga.web.forms;


import org.apache.struts.action.ActionForm;

public class CourseActionForm extends ActionForm {
	
	private int id;
	
	private String name;
	
	private int count;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
