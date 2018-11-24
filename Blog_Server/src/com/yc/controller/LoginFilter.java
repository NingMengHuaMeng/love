package com.yc.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns={"*.jsp","*.s"})
public class LoginFilter implements Filter {


    public LoginFilter() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		
		/**
		 * 实现排除权限访问控制的资源
		 */
		
		//获取当前访问资源名
		String path=httpServletRequest.getServletPath();   //返回访问的资源路径
		//判断资源名是否要拦截
		if (path.endsWith("user.s") || path.endsWith("login.jsp")) {
			//直接放行
			chain.doFilter(request, response);
			return;
		}
		
		if (httpServletRequest.getSession().getAttribute("loginUser")!=null) {
			//已经登陆
			//正常业务必须执行  过滤器链的  doFilter
			chain.doFilter(request, response);
		}else {
			//未登陆，跳转登陆界面
			request.setAttribute("msg", "请先登录！");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
