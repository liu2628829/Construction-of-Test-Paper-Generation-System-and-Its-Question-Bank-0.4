package com.lsxy.ga.manager;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.GaModle;

public interface  GaModleManager {
	
	public PagerModle findGaModel();
	
	public void addGaModle(GaModle ga);
	
	public void updateGaModle(GaModle ga);
	
	public void delGaModle(int id);
	
	public GaModle findGamodleById(int id);
	
	public void updateState(int id);
	
	public GaModle getGamodleByState();
}
