package com.lsxy.ga.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.CourseManager;
import com.lsxy.ga.model.Course;

import com.lsxy.ga.web.forms.CourseActionForm;


public class CourseAction extends DispatchAction {

	private CourseManager courseManager;
	/**
	 * 打开课程管理的主界面
	 */
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CourseActionForm cf = (CourseActionForm)form;
		PagerModle pm = courseManager.findCourses();
		request.setAttribute("pm",
				courseManager.findCourses()
		);
		
		return mapping.findForward("index");
	}
	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}
	
	
	public ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("add_input");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		CourseActionForm gaf = (CourseActionForm)form;
		
		Course cs = new Course();
		
		BeanUtils.copyProperties(cs,gaf);
		
		courseManager.addCourse(cs);
		
		return mapping.findForward("pub_add_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CourseActionForm gaf = (CourseActionForm)form;
		
		int id = gaf.getId();
		
		courseManager.delCourse(id);
		
		return mapping.findForward("pub_del_success");
	}
	
	

	public ActionForward  updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CourseActionForm cf = (CourseActionForm)form;
		request.setAttribute("course",courseManager.find(cf.getId()));
		return mapping.findForward("update_input");
		
	}
	
	public ActionForward  update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CourseActionForm cf = (CourseActionForm)form;
		Course cs = new Course();
		BeanUtils.copyProperties(cs,cf);
		courseManager.updateCourse(cs);
		return mapping.findForward("pub_update_success");
	}
	
}
