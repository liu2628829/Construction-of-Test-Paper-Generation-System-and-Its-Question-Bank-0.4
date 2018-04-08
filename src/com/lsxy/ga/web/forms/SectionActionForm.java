package com.lsxy.ga.web.forms;

import org.apache.struts.action.ActionForm;

public class SectionActionForm extends ActionForm {
	
	private int id;
	
	private String name;
	
	private int chapterId;

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

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
}
