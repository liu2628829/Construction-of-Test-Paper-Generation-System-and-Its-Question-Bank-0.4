package com.lsxy.ga.manager;

import com.lsxy.ga.PagerModle;
import com.lsxy.ga.SystemContext;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

//对于HibernateDaoSupport的对象管理
public class AbstractManager extends HibernateDaoSupport {
	
	public PagerModle searchPaginated(String hql){
		return searchPaginated(hql,null,SystemContext.getOffset(),SystemContext.getPagesize());
	}
	
	public PagerModle searchPaginated(String hql,Object param){
		return searchPaginated(hql,new Object[]{param},SystemContext.getOffset(),SystemContext.getPagesize());
	}
	
	public PagerModle searchPaginated(String hql,Object[] params){
		return searchPaginated(hql,params,SystemContext.getOffset(),SystemContext.getPagesize());
	}
	
	public PagerModle searchPaginated(String hql,int offset,int pagesize){
		return searchPaginated(hql,null,offset,pagesize);
	}
	 
	public PagerModle searchPaginated(String hql,Object obj,int offset,int pagesize){
		return searchPaginated(hql,new Object[]{obj},offset,pagesize);
	}
	
	/**
	 * 根据HQL语句进行分页查询
	 * @param hql HQL语句
	 * @param params HQL语句带的多个参数值
	 * @param offset 从第几条记录开始查询
	 * @param pagesize 每页显示多少行
	 * @return
	 */
	public PagerModle searchPaginated(String hql,Object[] params,int offset,int pagesize){
		
		//获取记录总数
		String countHql = getCountQuery(hql);
		Query query = getSession().createQuery(countHql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		int total = ((Long)query.uniqueResult()).intValue();
		
		//获取当前页的结果集
		query = getSession().createQuery(hql);
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
		
		query.setFirstResult(offset);
		query.setMaxResults(pagesize);
		List datas = query.list();
		
		PagerModle pm = new PagerModle();
		pm.setTotal(total);
		pm.setDatas(datas);
		return pm;
	}
	
	/**
	 * 根据HQL语句，获得查找总记录数的HQL语句
	 * 如：
	 * select ... from Orgnization o where o.parent is null
	 * 经过转换，可以得到：
	 * select count(*) from Orgnization o where o.parent is null
	 * @param hql
	 * @return
	 */
	private String getCountQuery(String hql){
		int index = hql.indexOf("from");
		if(index != -1){
			return "select count(*) " + hql.substring(index);
		}
		
		throw new SystemException("无效的HQL查询语句！");
	}
}
