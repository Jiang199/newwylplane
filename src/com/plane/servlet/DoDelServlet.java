package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.impdao.flightdaoimp;

public class DoDelServlet extends HttpServlet {

	public DoDelServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		request.getSession().getAttribute("admin");
		String flightid = request.getParameter("flightid");
		//直接根据航班号删除该航班
		int i = 0;
		flightdaoimp  dao = new flightdaoimp();
		i = dao.deleteoneflight(flightid);
		//跳转页面
		if(i>0)
		{
			response.getWriter().write("删除成功，3秒后跳回主界面");
	        response.setHeader("refresh", "3;url=admin1.jsp");
	        return;
		}
	}

}
