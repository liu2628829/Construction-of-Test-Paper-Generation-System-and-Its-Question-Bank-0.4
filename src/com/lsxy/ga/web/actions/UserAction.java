package com.lsxy.ga.web.actions;

import com.lsxy.ga.manager.UserManager;
import com.lsxy.ga.model.User;
import com.lsxy.ga.web.forms.UserActionForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction extends DispatchAction {
	
	private UserManager userManager;

	
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm", userManager.findUsers());
		
		return mapping.findForward("index");
	}
	
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("add_input");
	}


	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uf = (UserActionForm)form;

		User user = new User();
		BeanUtils.copyProperties(user, uf);
		userManager.addUser(user);
		
		return mapping.findForward("pub_add_success");
	}

	public ActionForward login(ActionMapping mapping, ActionForm form,
							 HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserActionForm uf = (UserActionForm)form;

		User user = new User();
		BeanUtils.copyProperties(user, uf);
		userManager.loginUser(user);

		return mapping.findForward("pub_add_success");
	}
	

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uf = (UserActionForm)form;
		userManager.delUser(uf.getId());
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uf = (UserActionForm)form;
		request.setAttribute("user", userManager.getById(uf.getId()));
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserActionForm uf = (UserActionForm)form;
		User us = new User();
		BeanUtils.copyProperties(us,uf);
		
		userManager.updateUser(us);
		
		return mapping.findForward("pub_update_success");
	}
	
	



	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
		
	}
	
	

}
