package com.lsxy.ga.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.commons.beanutils.BeanUtils;

import com.lsxy.ga.manager.ChapterManager;
import com.lsxy.ga.manager.CourseManager;
import com.lsxy.ga.manager.GaManager;
import com.lsxy.ga.manager.KnowledgePointManager;
import com.lsxy.ga.manager.PolicyManager;
import com.lsxy.ga.manager.SectionManager;
import com.lsxy.ga.manager.TypeManager;
import com.lsxy.ga.manager.UserManager;
import com.lsxy.ga.model.Chapter;
import com.lsxy.ga.model.KnowledgePoint;
import com.lsxy.ga.model.Policy;
import com.lsxy.ga.model.Section;
import com.lsxy.ga.model.TestQuestion;
import com.lsxy.ga.model.Type;
import com.lsxy.ga.web.forms.PolicyActionForm;

public class PolicyAction extends DispatchAction {

	PolicyManager policyManager;
	TypeManager typeManager;
	CourseManager courseManager;
	ChapterManager chapterManager;
	SectionManager SectionManager;
	KnowledgePointManager knowledgePointManager;
	UserManager userManager;
	private GaManager gaManager;


	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setAttribute("pm",policyManager.findPolicys());
		return mapping.findForward("index");
	}
	
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PolicyActionForm paf = (PolicyActionForm)form;
		policyManager.delPolicy(paf.getId());
		return mapping.findForward("pub_del_success");
	}
	
	public  ActionForward addInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			request.setAttribute("pm",typeManager.findTypes());
			return mapping.findForward("add_input");
	}
	
	public  ActionForward next(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PolicyActionForm paf = (PolicyActionForm)form;

		if(paf.getCourseId()==0){
			request.setAttribute("coutse", null);
		}else{
			request.setAttribute("course",courseManager.find(paf.getCourseId()));
			request.setAttribute("pm", chapterManager.findChapters(paf.getCourseId()));
		}
		
		return mapping.findForward("next_input");
	}
	
	public  ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PolicyActionForm paf = (PolicyActionForm)form;
		Policy p = new Policy();
		BeanUtils.copyProperties(p,paf);

		policyManager.addPolicy(p,paf.getCourseId(),1);
		return mapping.findForward("pub_add_success");
	}
	
	public  ActionForward detail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PolicyActionForm paf = (PolicyActionForm)form;
		Policy p = policyManager.getPolicyById(paf.getId()); 
		request.setAttribute("policy", p);
		

		String cpStr = p.getChapterIdInverse();
		List<Chapter> cpList= new ArrayList<Chapter>();
		int[] ra = null;
		if(cpStr!=null&&!cpStr.trim().equals("")){
			String[] cpStrings = cpStr.split(",");
			ra = new int[cpStrings.length];
			for(int i=0,j=0;i<cpStrings.length;i+=2,j++){
				int id = Integer.parseInt(cpStrings[i]);
				ra[j] = Integer.parseInt(cpStrings[i+1]);
				Chapter cp = chapterManager.getChapterById(id);
				cpList.add(cp);
			}
		}
		request.setAttribute("ra", ra);
		request.setAttribute("chapters", cpList);

		String seStr = p.getSections();
		List<Section> seList= new ArrayList<Section>();
		if(seStr!=null&&!seStr.trim().equals("")){
			String[] seStrings = seStr.split(",");
			for(int i=0;i<seStrings.length;i++){
				int id = Integer.parseInt(seStrings[i]);
				Section se = SectionManager.getSectionById(id);
				seList.add(se);
			}
		}
		request.setAttribute("sections",seList);


		String kpStr = p.getKnowledgePointIds();
		List<KnowledgePoint> kpList= new ArrayList<KnowledgePoint>();
		if(kpStr!=null&&!kpStr.trim().equals("")){
			String[] kpStrings = kpStr.split(",");
			for(int i=0;i<kpStrings.length;i++){
				int id = Integer.parseInt(kpStrings[i]);
				KnowledgePoint kp = knowledgePointManager.getKnowledgePointById(id);
				kpList.add(kp);
			}
		}
		request.setAttribute("knowledgePoints",kpList);
		
		
		String typeStr = p.getTypeQuantityMark();
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
		
		request.setAttribute("user",p.getUser());
		return mapping.findForward("detail");
		
	}


	

	public  ActionForward first(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("first");
	}  
	
	public  ActionForward intiPolcy(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("pm",typeManager.findTypes());
		return mapping.findForward("inti_input");
	}

	public  ActionForward intiPolcyNext(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PolicyActionForm paf = (PolicyActionForm)form;

		if(paf.getCourseId()==0){
			request.setAttribute("coutse", null);
		}else{
			request.setAttribute("course",courseManager.find(paf.getCourseId()));
			request.setAttribute("pm", chapterManager.findChapters(paf.getCourseId()));
		}
		return mapping.findForward("intiPolicyNext_input");
	}
	
	public  ActionForward startTest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PolicyActionForm paf = (PolicyActionForm)form;
		Policy p = new Policy();
		BeanUtils.copyProperties(p,paf);
		List<TestQuestion> tqList = gaManager.gaStart(p);

		System.out.print("是大法的："+tqList.size()+"dadadad");
		//policyManager.addPolicy(p,paf.getCourseId(),1);
		String tqIds = "";
//System.out.print("是大法的："+tqList.size()+"dadadad");
		for(int i=0;i<tqList.size();i++){
			tqIds += tqList.get(i).getId()+",";
		}
		
		request.setAttribute("tqIds",tqIds);
		request.setAttribute("policy", p);
		return mapping.findForward("success_test");
	}
	
	
	public PolicyManager getPolicyManager() {
		return policyManager;
	}

	public void setPolicyManager(PolicyManager policyManager) {
		this.policyManager = policyManager;
	}

	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}

	public CourseManager getCourseManager() {
		return courseManager;
	}

	public ChapterManager getChapterManager() {
		return chapterManager;
	}

	public void setChapterManager(ChapterManager chapterManager) {
		this.chapterManager = chapterManager;
	}

	public SectionManager getSectionManager() {
		return SectionManager;
	}

	public void setSectionManager(SectionManager sectionManager) {
		SectionManager = sectionManager;
	}

	public KnowledgePointManager getKnowledgePointManager() {
		return knowledgePointManager;
	}

	public void setKnowledgePointManager(KnowledgePointManager knowledgePointManager) {
		this.knowledgePointManager = knowledgePointManager;
	}
	public TypeManager getTypeManager() {
		return typeManager;
	}

	public void setTypeManager(TypeManager typeManager) {
		this.typeManager = typeManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public GaManager getGaManager() {
		return gaManager;
	}


	public void setGaManager(GaManager gaManager) {
		this.gaManager = gaManager;
	}

	
}
