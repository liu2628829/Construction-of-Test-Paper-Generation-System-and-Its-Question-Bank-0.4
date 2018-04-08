package com.lsxy.ga.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.manager.KnowledgePointManager;
import com.lsxy.ga.model.Course;
import com.lsxy.ga.model.KnowledgePoint;
import com.lsxy.ga.model.Section;
import com.lsxy.ga.web.forms.KnowledgePointActionForm;

public class KnowledgePointAction extends DispatchAction {

	private KnowledgePointManager knowledgePointManager;
	
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KnowledgePointActionForm kpf = (KnowledgePointActionForm)form;
		
		request.setAttribute("pm",
				knowledgePointManager.findPoints(kpf.getSectionId()));
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
		
		KnowledgePointActionForm kpf = (KnowledgePointActionForm)form;
		
        KnowledgePoint kp = new KnowledgePoint();
		
		BeanUtils.copyProperties(kp,kpf);
		
		knowledgePointManager.addPoint(kp,kpf.getSectionId());
		
		
		return mapping.findForward("pub_add_success");
	}
	

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		KnowledgePointActionForm kpf = (KnowledgePointActionForm)form;
		
        knowledgePointManager.delPoint(kpf.getId());
		
		return mapping.findForward("pub_del_success");
	}

	public void setKnowledgePointManager(KnowledgePointManager knowledgePointManager) {
		this.knowledgePointManager = knowledgePointManager;
	}
	
	
}
