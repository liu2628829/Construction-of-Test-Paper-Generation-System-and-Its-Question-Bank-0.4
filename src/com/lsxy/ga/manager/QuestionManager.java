package com.lsxy.ga.manager;

import java.util.List;

import com.lsxy.ga.model.TestQuestion;

public interface QuestionManager {
	/**
	 *添加试题 
	 */
	public void addQuestion(TestQuestion tq);
	/**
	 * 更新试题
	 * @param tq 要更新的题目
	 */
	public void updateQuestion(TestQuestion tq);
	/**
	 *删除试题
	 * @param QuestionId 要删除试题的编号
	 */
	public void delQuestion(int QuestionId);
	
	/**
	 * 查找该课程下的所有试题
	 * @param courseId 课程id
	 * @return
	 */
	public List<TestQuestion> findCourseId(int courseId);
	
	/**
	 * 查找该章节下的所有试题
	 * @param chapterId 章节id
	 * @return
	 */
	public List<TestQuestion> findChapterId(int chapterId);
	
}
