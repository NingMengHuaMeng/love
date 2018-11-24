package com.yc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.biz.UserBiz;
import com.yc.dao.BeanUtils;

/**
 * 用户Servlet  包含登录，注册，查询，退出，忘记密码
 * 使用op字段标识业务操作类型
 */
@WebServlet("/user.s")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz=new UserBiz();




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String op=request.getParameter("op");
		if("login".equals(op)){
			login(request,response);
		}else if("query".equals(op)){
			query(request,response);
		}else if("add".equals(op)){
			add(request,response);
		}else if("find".equals(op)){
			find(request,response);
		}
	}
	

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		User user=userBiz.findByid(id);
		//将user返回给页面
		String userString=JSON.toJSONString(user);
		response.getWriter().append(userString);  ///基于jQuery
		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setCharacterEncoding("utf-8");
		//接收页面传回的参数
		//将参数加载到user对象里面
		User user=BeanUtils.asBean(request, User.class);
		//调用BeanUtils.add方法   将用户添加到数据库
		try {
			userBiz.add(user);
		} catch (BizException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}finally{
			//如果成功则调到用户查询的界面
			//如果成功，也就调到用户的查询界面
			query(request, response);
		}
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		User user=BeanUtils.asBean(request, User.class);
		
		request.setAttribute("userlist", userBiz.find(user));
		request.getRequestDispatcher("manage-user.jsp").forward(request, response);
	}

	//
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		//抽取业务逻辑的方式
		UserBiz userBiz=new UserBiz();
		//Map<String, String> user= userBiz.login(username, userpwd);
		User user=null;
		
		try {
			user=userBiz.login(username, userpwd);
		} catch (BizException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			//失败
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		if( user== null){
			request.setAttribute("msg", "用户名或密码错误");
			//失败
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//用户信息保存在会话中
			request.getSession().setAttribute("loginUser", user);
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
