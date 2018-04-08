package com.lsxy.ga.model;

import java.util.Set;

/**
 * 
 * @author lmx
 *@hibernate.class table="t_section"
 */
public class Section {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * @hibernate.many-to-one column="chapterId"
	 */
	private Chapter cp;
	
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="sectionId"
	 * @hibernate.one-to-many class="com.lsxy.ga.model.KnowledgePoint"
	 */
	private Set children;

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

	public Chapter getCp() {
		return cp;
	}

	public void setCp(Chapter cp) {
		this.cp = cp;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}
}
