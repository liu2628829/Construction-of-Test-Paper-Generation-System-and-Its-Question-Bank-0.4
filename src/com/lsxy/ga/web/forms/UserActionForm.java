package com.lsxy.ga.web.forms;

import org.apache.struts.action.ActionForm;

public class UserActionForm extends ActionForm {
	
		private int id;//用户编号
		
		private String name;//用户称呼
		
		private String userName;//用户名
		
		private String password;//密码
		private int popedom;//权限
		public int getPopedom() {
			return popedom;
		}

		public void setPopedom(int popedom) {
			this.popedom = popedom;
		}

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
		
}
