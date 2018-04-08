package com.lsxy.ga.model;

import java.util.Set;


  /**
  *  
  * @author Administrator
  * @hibernate.class table="t_chapter"
  */ 

public class Chapter {
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	//章节编号
	private int id;
	
	/**
	 * @hibernate.property
	 */ 
	//章节名称
	private String name;
	
	/**
	 * @hibernate.many-to-one column="courseId"
	 */
	//所属课程
	private Course  cs;
	
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="chapterId"
	 * @hibernate.one-to-many class="com.lsxy.ga.model.Section"
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

	public Course getCs() {
		return cs;
	}

	public void setCs(Course cs) {
		this.cs = cs;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}
}
