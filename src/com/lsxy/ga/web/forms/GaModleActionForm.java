package com.lsxy.ga.web.forms;

import org.apache.struts.action.ActionForm;

public class GaModleActionForm extends ActionForm {
	
	private int id;//编号

	private int generation; //进化代数

    private int population; //种群数量

    private double crossoverPossibility; //交叉概率 
    
    private double mutationPossibility; //变异概率
    
    private boolean state;//参数使用状态

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
    
}
