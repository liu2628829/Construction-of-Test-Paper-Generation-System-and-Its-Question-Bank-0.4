package com.lsxy.ga.model;


/**
 * @hibernate.class table="t_knowledgepoint"
 * @author lmx
 *
 */
public class KnowledgePoint {
	
	/**
	*@hibernate.id
	* 		generator-class="native"
	*/
	private int id;
	
	/**
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * @hibernate.many-to-one column="sectionId"
	 */
	private Section ct;

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

	public Section getCt() {
		return ct;
	}

	public void setCt(Section ct) {
		this.ct = ct;
	}

	

	
}
