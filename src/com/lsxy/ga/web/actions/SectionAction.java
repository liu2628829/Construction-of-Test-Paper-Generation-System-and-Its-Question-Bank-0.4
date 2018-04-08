package com.lsxy.ga.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.manager.SectionManager;
import com.lsxy.ga.model.Section;
import com.lsxy.ga.web.forms.SectionActionForm;

public class SectionAction extends DispatchAction {

	public SectionManager sectionManager;
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SectionActionForm  saf = (SectionActionForm)form;
		
		request.setAttribute("pm", sectionManager.findSections(saf.getChapterId()));
		
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
		
		SectionActionForm  saf = (SectionActionForm)form;
		
		Section st = new Section();
		
		BeanUtils.copyProperties(st,saf);
		
		sectionManager.addSection(st,saf.getChapterId());
		
		return mapping.findForward("pub_add_success");
	}
	
	
	public void setSectionManager(SectionManager sectionManager) {
		this.sectionManager = sectionManager;
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SectionActionForm saf = (SectionActionForm)form;
		
		sectionManager.delSection(saf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
}
