package com.lsxy.ga.manager;

import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.model.Dwrmodle;
import com.lsxy.ga.model.Type;

public interface  TypeManager {
	
	public void addType(Type t);
	
	public void updateType(Type t);
	
	public PagerModle findTypes();
	
	public List<Dwrmodle> getScriptTypes();
	
	public void delType(int id);
	
	public Type getTypeById(int id);
	
	public List getTypeByIds(int[] typeIds);
}
