package com.lsxy.ga.manager;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lsxy.ga.model.GaModle;
import com.lsxy.ga.model.Policy;
import com.lsxy.ga.model.TestQuestion;
import com.lsxy.ga.model.Type;
import com.lsxy.ga.RandomNo;
/**
 *组卷算法管理
 */
public interface GaManager {
	public void intiLib(int[] knowledgePointIds,int[] typeIds);
	public List<List<TestQuestion>> ChromosomeInti(Policy p,GaModle gm);
	public int getAdaptive(List<TestQuestion> qsList,Policy p); 
	public void sortChr(List<List<TestQuestion>>  chromosomeList);
	public void crossDo(List<List<TestQuestion>>  chromosomeList);
	public void mutationDo(List<List<TestQuestion>>  chromosomeList);
	
	public List<TestQuestion> gaStart(Policy p);
}


