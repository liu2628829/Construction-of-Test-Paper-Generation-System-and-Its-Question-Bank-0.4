package com.lsxy.ga.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.manager.AbstractManager;
import com.lsxy.ga.manager.TypeManager;
import com.lsxy.ga.model.Dwrmodle;
import com.lsxy.ga.model.Section;
import com.lsxy.ga.model.Type;

public class TypeManagerImpl extends AbstractManager  implements TypeManager {

	@Override
	public void addType(Type t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public PagerModle findTypes() {
		
		return searchPaginated("from Type");
	}

	@Override
	public void updateType(Type t) {

		getHibernateTemplate().update(t);
	}

	@Override
	public void delType(int id) {
		
		Type t = (Type)getHibernateTemplate().load(Type.class, id);
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public Type getTypeById(int id) {
		Type t  = (Type)getHibernateTemplate().load(Type.class, id);
		return t;
	}

	@Override
	public List<Dwrmodle> getScriptTypes() {
		List<Dwrmodle>  dwr = new ArrayList<Dwrmodle>();
		List<Type> types = getSession().createQuery("from Type").list();
		for(int i=0;i<types.size();i++){
			Dwrmodle dm = new Dwrmodle();
			dm.setId(types.get(i).getId());
			dm.setName(types.get(i).getName());
			dwr.add(dm);
		}
		return  dwr;
	}

	@Override
	public List getTypeByIds(int[] typeIds) {
		String hql = "from Type t where t.id in (";
		
		for(int i=0;i<typeIds.length;i++){
			if(i==typeIds.length-1){
				hql += typeIds[i]+")";
			}else{
				hql += typeIds[i]+",";
			}
		}
//System.out.print("查询语句打印"+hql);
		List tyList = getSession().createQuery(hql).list();
		
		return tyList;
	}
	


	
}
