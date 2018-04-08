package com.lsxy.ga.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.manager.TypeManager;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Type;
import com.lsxy.ga.model.User;
import com.lsxy.ga.web.forms.ChapterActionForm;
import com.lsxy.ga.web.forms.CourseActionForm;
import com.lsxy.ga.web.forms.TypeActionForm;
import com.lsxy.ga.web.forms.UserActionForm;

public class TypeAction extends DispatchAction {

	private TypeManager typeManager;
	
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TypeActionForm gaf = (TypeActionForm)form;
		request.setAttribute("pm",
				typeManager.findTypes()
		);			
		
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
			
		TypeActionForm cpf = (TypeActionForm)form;

		Type t = new Type();
		
		BeanUtils.copyProperties(t, cpf);

		typeManager.addType(t);
		
		return mapping.findForward("pub_add_success");

	}
	
	public ActionForward  del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TypeActionForm tf = (TypeActionForm)form;
		typeManager.delType(tf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	public ActionForward  updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TypeActionForm tf = (TypeActionForm)form;
		request.setAttribute("type",typeManager.getTypeById(tf.getId()));
		return mapping.findForward("update_input");
		
	}
	
	public ActionForward  update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TypeActionForm tf = (TypeActionForm)form;
		Type t = new Type();
		BeanUtils.copyProperties(t,tf);
		typeManager.updateType(t);
		return mapping.findForward("pub_update_success");
	}
	
	
	
	
	
	
	
	
	public TypeManager getTypeManager() {
		return typeManager;
	}

	public void setTypeManager(TypeManager typeManager) {
		this.typeManager = typeManager;
	}


}
