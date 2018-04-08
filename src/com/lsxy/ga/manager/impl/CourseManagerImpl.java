package com.lsxy.ga.manager.impl;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;

import com.lsxy.ga.manager.SystemException;
import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.CourseManager;
import com.lsxy.ga.model.Course;

public class CourseManagerImpl extends AbstractManager implements CourseManager {


	public void addCourse(Course cs) {
		getHibernateTemplate().save(cs);
	}

	public void delCourse(int courseId) {
		
		
		//List<Chapter>  cps =getSession().createQuery("from Chapter c where c.cs="+courseId).list();
		//for(int i=0;i<cps.size();i++){
		//	System.out.print(cps.get(i).getName());
		//}
		
		
		int count = ((Long)getSession().
					createQuery("select count(*) from Chapter  where courseId="+courseId).
					uniqueResult()).intValue();
		if(count>0){
			throw new SystemException("下面有章节，不允许删除");
		}
		Course course = (Course)getHibernateTemplate().load(Course.class, courseId);
		getHibernateTemplate().delete(course);
	}


	public void updateCourse(Course cs) {
		getHibernateTemplate().update(cs);

	}

	public PagerModle findCourses() {
		
		return searchPaginated("from Course");
	}


	public Course find(int courseId) {
		
		return (Course)getHibernateTemplate().load(Course.class, courseId);

	}


	public List<Course> findCoursesScript() {
		
		List<Course> courses = new ArrayList<Course>();
	
		Query query = getSession().createQuery("from Course");
		courses = query.list();
		return courses;
	}


	



}
