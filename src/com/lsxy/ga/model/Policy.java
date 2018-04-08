package com.lsxy.ga.model;

/**
 * 
 * @author lmx
 *@hibernate.class table="t_policy"
 */

public class Policy {
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;//策略编号
	/**
	 * @hibernate.property
	 */
	private String name;//策略名称
	/**
	 * @hibernate.many-to-one
	 */
	private Course course;//试题所属课程
	/**
	 * @hibernate.property
	 */
	private int mark;//试卷总分
	/**
	 * @hibernate.property
	 */
	private int time;//考试时间
	/**
	 * @hibernate.property
	 */
	private int count;//试题总数
	/**
	 * @hibernate.property
	 */
	private double difficulty;//试卷难度
	/**
	 * @hibernate.property
	 */
	private double differentiate;//试卷区分度
	/**
	 * @hibernate.property
	 */

	private double Exposure;//试卷的曝光度
	/**
	 * @hibernate.property
	 */
	private String chapterIdInverse;//所有章的id字符串
	/**
	 * @hibernate.property
	 */
	private String sections;//所有小节的字符串
	/**
	 * @hibernate.property
	 */
	private String knowledgePointIds;//所有知识点的字符串
	/**
	 * @hibernate.property
	 */
	private String typeQuantityMark;//所有试题类型和题型分数和题量字符串
	/**
	 * @hibernate.many-to-one
	 */
	private User user;//组卷用户
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public double getDifferentiate() {
		return differentiate;
	}

	public void setDifferentiate(double differentiate) {
		this.differentiate = differentiate;
	}

	public String getChapterIdInverse() {
		return chapterIdInverse;
	}

	public void setChapterIdInverse(String chapterIdInverse) {
		this.chapterIdInverse = chapterIdInverse;
	}

	public String getSections() {
		return sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public String getKnowledgePointIds() {
		return knowledgePointIds;
	}

	public void setKnowledgePointIds(String knowledgePointIds) {
		this.knowledgePointIds = knowledgePointIds;
	}

	public String getTypeQuantityMark() {
		return typeQuantityMark;
	}

	public void setTypeQuantityMark(String typeQuantityMark) {
		this.typeQuantityMark = typeQuantityMark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getExposure() {
		return Exposure;
	}

	public void setExposure(double exposure) {
		Exposure = exposure;
	}

}
