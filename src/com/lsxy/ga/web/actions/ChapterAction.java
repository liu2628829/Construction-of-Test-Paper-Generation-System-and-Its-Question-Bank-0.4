package com.lsxy.ga.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.manager.ChapterManager;
import com.lsxy.ga.manager.CourseManager;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.Course;
import com.lsxy.ga.web.forms.ChapterActionForm;

public class ChapterAction extends DispatchAction {

	private ChapterManager chapterManager;

	
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ChapterActionForm cpf = (ChapterActionForm)form;

		request.setAttribute("pm",chapterManager.findChapters(cpf.getCourseId()));
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
		
		
		ChapterActionForm cpf = (ChapterActionForm)form;

		request.setAttribute("pm",chapterManager.findChapters(cpf.getCourseId()));
		
		Chapter cp = new Chapter();
		
		BeanUtils.copyProperties(cp, cpf);

		chapterManager.addChapter(cp,cpf.getCourseId());
		
		return mapping.findForward("pub_add_success");
	}
	
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ChapterActionForm cpf = (ChapterActionForm)form;
		
		chapterManager.updateChapter(cpf.getId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ChapterActionForm cpf = (ChapterActionForm)form;
		
		chapterManager.delChapter(cpf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	public void setChapterManager(ChapterManager chapterManager) {
		this.chapterManager = chapterManager;
	}


	

}
