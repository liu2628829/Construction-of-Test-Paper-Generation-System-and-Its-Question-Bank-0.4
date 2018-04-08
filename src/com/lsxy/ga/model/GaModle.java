package com.lsxy.ga.model;

/**
 * @hibernate.class table = "t_gamodle"
 * @author lmx
 *
 */
public class GaModle {
	/**  
	*@hibernate.id
	* 		generator-class="native"
	*/
	private int id;//编号
	/**
	 * @hibernate.property
	 */
	private int generation; //进化代数
	/**
	 * @hibernate.property
	 */
    private int population; //种群数量
	/**
	 * @hibernate.property
	 */
    private double crossoverPossibility; //交叉概率
	/**
	 * @hibernate.property
	 */
    private double mutationPossibility; //变异概率
	/**
	 * @hibernate.property
	 */
    private boolean state;//组卷状态
    
	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getCrossoverPossibility() {
		return crossoverPossibility;
	}

	public void setCrossoverPossibility(double crossoverPossibility) {
		this.crossoverPossibility = crossoverPossibility;
	}

	public double getMutationPossibility() {
		return mutationPossibility;
	}

	public void setMutationPossibility(double mutationPossibility) {
		this.mutationPossibility = mutationPossibility;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
