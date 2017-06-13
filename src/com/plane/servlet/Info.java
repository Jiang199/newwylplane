package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Info extends HttpServlet {


	public Info() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		request.getSession().getAttribute("user");  
        if((request.getSession().getAttribute("user"))==null){  
        	response.getWriter().write("用户未登陆，3秒后跳转登陆页面！");
	        response.setHeader("refresh", "3;url=login.jsp");
	        return;
        }else{
        	response.sendRedirect(request.getContextPath()+"/info.jsp");
        }
	}

}
