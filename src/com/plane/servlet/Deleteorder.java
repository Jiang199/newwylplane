package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.impdao.userdaoimp;

public class Deleteorder extends HttpServlet {

	public Deleteorder() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获得航班号
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("Id");
		System.out.println(id);
		//获得用户名
		String user = (String)request.getSession().getAttribute("user");
		System.out.println(user);
		//根据用户名和航班号，删除订单
		userdaoimp os = new userdaoimp();
		int i = 0;
		try {
			i = os.deleteorder(id,user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
			response.getWriter().write("退票成功，3秒后跳转用户管理中心！");
	        response.setHeader("refresh", "3;url=info.jsp");
	        return;
		}
	}

}
