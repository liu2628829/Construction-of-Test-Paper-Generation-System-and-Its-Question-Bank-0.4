package com.lsxy.ga.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.lsxy.ga.SystemContext;

public class PagerFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		SystemContext.setOffset(getOffset(httpRequest));
		SystemContext.setPagesize(getPagesize(httpRequest));
		
		try{
			chain.doFilter(request, response);
		}finally{
			//清空ThreadLocal中的值
			SystemContext.removeOffset();
			SystemContext.removePagesize();
		}
		
	}
	
	protected int getOffset(HttpServletRequest request){
		int offset = 0;
		try {
			offset = (Integer.parseInt(request.getParameter("pager.offset")))/10;
		} catch (NumberFormatException ignore) {
		}
		if(offset!=0){
			offset = offset+offset*this.getPagesize(request)-1;
		}
		return offset;
	}
	
	protected int getPagesize(HttpServletRequest request){
		return 10;
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
