package com.lsxy.ga.model;


/**
 * @hibernate.class table="t_type"
 * @author lmx
 *
 */
public class Type {
	
	
	/**
	 * @hibernate.id 
	 * 		generator-class="native"
	 */
	private int id; 
	
	/**
	 * @hibernate.property
	 */
	private String name;

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
}
