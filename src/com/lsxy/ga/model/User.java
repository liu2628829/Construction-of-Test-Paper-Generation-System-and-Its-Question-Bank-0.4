package com.lsxy.ga.model;


/**
 * @hibernate.class table="t_user"
 * @author lmx
 *
 */
public class User {
	/**
	 * @hibernate.id 
	 * 		generator-class="native"
	 */
	private int id;//用户编号
	/**
	 * @hibernate.property
	 */
	private String name;//用户称呼
	/**
	 * @hibernate.property
	 */
	private String userName;//用户名
	/**
	 * @hibernate.property
	 */
	private String password;//密码
	/**
	 * @hibernate.property
	 */
	private int popedom;//用户权限 0 表示普通用户 1 表示专家用户 2 表示系统管理员

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPopedom() {
		return popedom;
	}

	public void setPopedom(int popedom) {
		this.popedom = popedom;
	}
}
