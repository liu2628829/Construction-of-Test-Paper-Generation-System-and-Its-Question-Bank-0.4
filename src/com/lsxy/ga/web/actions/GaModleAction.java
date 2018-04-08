package com.lsxy.ga.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.manager.GaModleManager;
import com.lsxy.ga.model.GaModle;
import com.lsxy.ga.model.Type;
import com.lsxy.ga.web.forms.GaModleActionForm;
import com.lsxy.ga.web.forms.TypeActionForm;

public class GaModleAction extends DispatchAction {

	private GaModleManager gaModleManager;
	
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm", gaModleManager.findGaModel());
		
		return mapping.findForward("index");
	}
	
	public  ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GaModleActionForm gaf = (GaModleActionForm)form;
		gaModleManager.delGaModle(gaf.getId());
		return mapping.findForward("pub_del_success");
	}
	
	public  ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("add_input");
	}
	
	
	
	public  ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		GaModleActionForm gaf = (GaModleActionForm)form;
//System.out.print("检测参数==》"+gaf.isState());
		GaModle ga = new GaModle();
		
		BeanUtils.copyProperties(ga, gaf);

		gaModleManager.addGaModle(ga);	
		
		return mapping.findForward("pub_add_success");
	}
	
	public  ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GaModleActionForm gaf = (GaModleActionForm)form;
		request.setAttribute("gamodle", gaModleManager.findGamodleById(gaf.getId()));
//System.out.print("检测参数==》"+gaModleManager.findGamodleById(gaf.getId()).isState());
		return mapping.findForward("update_input");
	}
	
	
	public  ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		GaModleActionForm gaf = (GaModleActionForm)form;
		GaModle ga = new GaModle();
		BeanUtils.copyProperties(ga, gaf);
		gaModleManager.updateGaModle(ga);
		return mapping.findForward("pub_update_success");
	}
	
	
	public void setGaModleManager(GaModleManager gaModleManager) {
		this.gaModleManager = gaModleManager;
	}
	 
}
