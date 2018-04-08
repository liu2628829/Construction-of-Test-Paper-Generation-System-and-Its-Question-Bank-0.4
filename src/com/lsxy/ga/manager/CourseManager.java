package com.lsxy.ga.manager;

import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.Course;

public interface CourseManager {
	/**
	 * 增加一门课程
	 * @param cs
	 */
	public void addCourse(Course cs);
	
	/**
	 * 删除一门课程
	 * @param CourseId
	 */
	public void delCourse(int CourseId);
	
	/**
	 *更新一门课程
	 * @param cs
	 */
	public void updateCourse(Course cs);
	
	/**
	 *显示所有的课程
	 * @return
	 */
	public PagerModle findCourses();
	
	public List<Course> findCoursesScript();
		
	public Course find(int courseId);
	

}
