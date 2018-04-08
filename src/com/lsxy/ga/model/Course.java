package com.lsxy.ga.model;

import java.util.Set;

/**
 * 
 * @author Administrator
 * @hibernate.class table="t_course"
 */ 

public class Course {
	
	
	/**
	 * @hibernate.id 
	 * 		generator-class="native"
	 */
	//课程的编号
	private int id;
	
	/**
	 * @hibernate.property
	 */
	//课程名称
	private String name;
	
	/**
	 * @hibernate.property
	 */
	//组卷次数
	private int count;
	
	/**
	 * @hibernate.set inverse="true" lazy="extra"
	 * @hibernate.key column="courseId"
	 * @hibernate.one-to-many class="com.lsxy.ga.model.Chapter"
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}
	
}
