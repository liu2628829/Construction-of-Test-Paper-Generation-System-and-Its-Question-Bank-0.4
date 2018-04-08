package com.lsxy.ga.web.forms;

import org.apache.struts.action.ActionForm;


public class ChapterActionForm extends ActionForm {

	private int id;

	private String name;
	
	private int  courseId;

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
}
