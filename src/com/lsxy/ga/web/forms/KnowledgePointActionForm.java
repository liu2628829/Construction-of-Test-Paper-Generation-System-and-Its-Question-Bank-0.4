package com.lsxy.ga.web.forms;

import org.apache.struts.action.ActionForm;

public class KnowledgePointActionForm extends ActionForm {
	
	private int id;
	
	private String name;
	
	private int sectionId;

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

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	
}
