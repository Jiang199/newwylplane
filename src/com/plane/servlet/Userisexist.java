package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.impdao.userdaoimp;

public class Userisexist extends HttpServlet {

	
	public Userisexist() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		//定义输出流
        PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		System.out.println("要注册的用户名 为"+username);
		userdaoimp  dao = new userdaoimp();
		boolean  isuser;
		try {
			isuser = dao.isexist(username); //返回true就是可以注册，返回false就是不可用注册
			if(isuser==true){
				out.print("<font color='green'>您可以注册该用户名</font>");
			}else{
				out.print("<font color='red'>用户名已被注册</font> ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			//request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

}
