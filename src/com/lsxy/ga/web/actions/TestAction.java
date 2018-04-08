package com.lsxy.ga.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lsxy.ga.manager.TestManager;
import com.lsxy.ga.manager.TestQuestionManager;
import com.lsxy.ga.manager.TypeManager;
import com.lsxy.ga.model.Test;
import com.lsxy.ga.model.TestQuestion;
import com.lsxy.ga.model.Type;
import com.lsxy.ga.web.forms.TestActionForm;
import org.apache.commons.beanutils.BeanUtils;

public class TestAction extends DispatchAction {
	
	TestQuestionManager testQuestionManager;
	TypeManager typeManager;
	TestManager testManager; 
	
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("pm", testManager.findTests());
		return mapping.findForward("index");
	}
	

	public  ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestActionForm taf = (TestActionForm)form;
		
		
		String testStr = taf.getTestQuestions();
		String[] testQuestionIds = testStr.split(",");
		List<TestQuestion> testList = new ArrayList<TestQuestion>();
		for(int i=0;i<testQuestionIds.length;i++){
			int id =Integer.parseInt(testQuestionIds[i]);
			TestQuestion q = testQuestionManager.getTestQuestionById(id);
			testList.add(q);
		}
		request.setAttribute("testList", testList);
		
		String typeStr = taf.getTypes();
System.out.println("测试参数"+typeStr+"这确否");
		List<Type> typeList = new ArrayList<Type>();
		int[] sourse=null; 
		int[] counts=null;
		if(typeStr!=null&&!typeStr.trim().equals("")){
			String[] typeStrings = typeStr.split(",");
			int typeLength = typeStrings.length;
			sourse = new int[typeLength/3];
			counts =new int[typeLength/3];
			for(int i=0,j=0;i<typeLength;i+=3,j++){
				int id = Integer.parseInt(typeStrings[i]);
				Type t = typeManager.getTypeById(id);
				typeList.add(t);
				sourse[j] = Integer.parseInt(typeStrings[i+1]);
				counts[j] = Integer.parseInt(typeStrings[i+2]);
			}
		}
		request.setAttribute("types",typeList);
		request.setAttribute("ses",sourse);
		request.setAttribute("tycs",counts);
		request.setAttribute("zu", 0);
		
		return mapping.findForward("detail");
	}

	public  ActionForward detailIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestActionForm tf = (TestActionForm)form;
	
		Test taf  = testManager.getTestById(tf.getId());
		
		String testStr = taf.getTestQuestions();
		String[] testQuestionIds = testStr.split(",");
		List<TestQuestion> testList = new ArrayList<TestQuestion>();
		for(int i=0;i<testQuestionIds.length;i++){
			int id =Integer.parseInt(testQuestionIds[i]);
			TestQuestion q = testQuestionManager.getTestQuestionById(id);
			testList.add(q);
		}
		request.setAttribute("testList", testList);
		
		String typeStr = taf.getTypes();
System.out.println("测试参数"+typeStr+"这确否");
		List<Type> typeList = new ArrayList<Type>();
		int[] sourse=null; 
		int[] counts=null;
		if(typeStr!=null&&!typeStr.trim().equals("")){
			String[] typeStrings = typeStr.split(",");
			int typeLength = typeStrings.length;
			sourse = new int[typeLength/3];
			counts =new int[typeLength/3];
			for(int i=0,j=0;i<typeLength;i+=3,j++){
				int id = Integer.parseInt(typeStrings[i]);
				Type t = typeManager.getTypeById(id);
				typeList.add(t);
				sourse[j] = Integer.parseInt(typeStrings[i+1]);
				counts[j] = Integer.parseInt(typeStrings[i+2]);
			}
		}
		request.setAttribute("types",typeList);
		request.setAttribute("ses",sourse);
		request.setAttribute("tycs",counts);
		
		tf.setName(taf.getName());
		tf.setCountTime(taf.getCountTime());
		tf.setMark(taf.getMark());
		request.setAttribute("zu", 1);
		return mapping.findForward("detail");
	}
	
	public  ActionForward detailAnswer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestActionForm tf = (TestActionForm)form;
	
		Test taf  = testManager.getTestById(tf.getId());
		
		String testStr = taf.getTestQuestions();
		String[] testQuestionIds = testStr.split(",");
		List<TestQuestion> testList = new ArrayList<TestQuestion>();
		for(int i=0;i<testQuestionIds.length;i++){
			int id =Integer.parseInt(testQuestionIds[i]);
			TestQuestion q = testQuestionManager.getTestQuestionById(id);
			testList.add(q);
		}
		request.setAttribute("testList", testList);
		
		String typeStr = taf.getTypes();
System.out.println("测试参数"+typeStr+"这确否");
		List<Type> typeList = new ArrayList<Type>();
		int[] sourse=null; 
		int[] counts=null;
		if(typeStr!=null&&!typeStr.trim().equals("")){
			String[] typeStrings = typeStr.split(",");
			int typeLength = typeStrings.length;
			sourse = new int[typeLength/3];
			counts =new int[typeLength/3];
			for(int i=0,j=0;i<typeLength;i+=3,j++){
				int id = Integer.parseInt(typeStrings[i]);
				Type t = typeManager.getTypeById(id);
				typeList.add(t);
				sourse[j] = Integer.parseInt(typeStrings[i+1]);
				counts[j] = Integer.parseInt(typeStrings[i+2]);
			}
		}
		request.setAttribute("types",typeList);
		request.setAttribute("ses",sourse);
		request.setAttribute("tycs",counts);
		
		tf.setName(taf.getName());
		tf.setCountTime(taf.getCountTime());
		tf.setMark(taf.getMark());
		request.setAttribute("zu", 1);
		return mapping.findForward("detailAnswer");
	}
	
	
	public  ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestActionForm taf = (TestActionForm)form;
		Test t = new Test();
		BeanUtils.copyProperties(t, taf);
		testManager.addTest(t, 1);
		return mapping.findForward("pub_add_success");
	}
	

	public  ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestActionForm taf = (TestActionForm)form;
		testManager.delTest(taf.getId());
		
		return mapping.findForward("pub_del_success");
	}
	
	
	
	public TestQuestionManager getTestQuestionManager() {
		return testQuestionManager;
	}


	public void setTestQuestionManager(TestQuestionManager testQuestionManager) {
		this.testQuestionManager = testQuestionManager;
	}


	public TypeManager getTypeManager() {
		return typeManager;
	}


	public void setTypeManager(TypeManager typeManager) {
		this.typeManager = typeManager;
	}


	public TestManager getTestManager() {
		return testManager;
	}


	public void setTestManager(TestManager testManager) {
		this.testManager = testManager;
	}


}
