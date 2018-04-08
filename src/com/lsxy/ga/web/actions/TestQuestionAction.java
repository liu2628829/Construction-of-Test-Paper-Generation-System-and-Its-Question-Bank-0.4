package com.lsxy.ga.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.manager.GaManager;
import com.lsxy.ga.manager.TestQuestionManager;
import com.lsxy.ga.model.Policy;
import com.lsxy.ga.model.TestQuestion;
import com.lsxy.ga.web.forms.TestQuestionActionForm;

public class TestQuestionAction extends DispatchAction {

	private TestQuestionManager testQuestionManager;


	protected  ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int chapterId = Integer.parseInt(request.getParameter("chapterId"));
		int sectionId = Integer.parseInt(request.getParameter("sectionId"));
		int knowledgePointId =Integer.parseInt(request.getParameter("knowledgePointId"));
		request.setAttribute("pm", testQuestionManager.findTestQuestions(courseId, chapterId, sectionId, knowledgePointId));
		return mapping.findForward("index");
	}
	
	
	
	
	public  ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		return mapping.findForward("add_input");
	}
	
	public  ActionForward addResultInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestQuestionActionForm tqf = (TestQuestionActionForm)form;
		request.setAttribute("testQuestion",testQuestionManager.getTestQuestionById(tqf.getId()));
		return mapping.findForward("add_result_input");
	}
	
	public  ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			TestQuestionActionForm tqf = (TestQuestionActionForm)form;
			TestQuestion tq = new TestQuestion();
			BeanUtils.copyProperties(tq, tqf);
			tq.setLateTime(new java.util.Date(System.currentTimeMillis()));
			tq.setCount(5);
			tq.setState(0);
			testQuestionManager.addTestQuestion(tq, tqf.getTypeId(),tqf.getCourseId(),tqf.getChapterId(), tqf.getSectionId(),tqf.getKnowledgePointId());
		    request.setAttribute("testQuestion",testQuestionManager.getTestQuestionByDate(tq.getLateTime()));
			return mapping.findForward("add_result_input");
	}
	
	public  ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
			TestQuestionActionForm tqf = (TestQuestionActionForm)form;
			request.setAttribute("testQuestion", testQuestionManager.getTestQuestionById(tqf.getId()));
		    return mapping.findForward("detail");
	}
	
	public  ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestQuestionActionForm tqf = (TestQuestionActionForm)form;
		TestQuestion tq = testQuestionManager.getTestQuestionById(tqf.getId());
		tq.setResult(tqf.getResult());
		tq.setState(1);
		testQuestionManager.updateTestQuestion(tq);
		return mapping.findForward("pub_update_success");
	}
	
	
	public  ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestQuestionActionForm tqf = (TestQuestionActionForm)form;
		
		testQuestionManager.delTestQuestion(tqf.getId());
		return mapping.findForward("pub_del_success");
	}
	
	public void setTestQuestionManager(TestQuestionManager testQuestionManager) {
		this.testQuestionManager = testQuestionManager;
	}

	public TestQuestionManager getTestQuestionManager() {
		return testQuestionManager;
	}
	
}
