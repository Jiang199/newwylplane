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
import com.sun.xml.internal.txw2.Document;

public class servletbuy extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servletbuy() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		//获取数据
		String name = request.getParameter("userid"); //获得购买的用户名
		String flightid = request.getParameter("flightid");//获取航班号
		System.out.println("the name is !!! "+name);
		System.out.println("the flightid is !!!"+flightid);
		if(name==null){
			response.getWriter().write("用户未登陆，3秒后跳转登陆页面！");
	        response.setHeader("refresh", "3;url=login.jsp");
	        return;
		}else{
			//处理数据
			userdaoimp userdao = new userdaoimp();
			try {
				if(userdao.buytickets(name,flightid))
				{
					//购买成功，转发处理
					response.getWriter().write("购票成功，3秒后跳转主页！");

				    response.setHeader("refresh", "3;url=pageservlet");
				}
				else{
					//购票失败，转发处理
					response.getWriter().write("购票失败，3秒后跳转登陆页面！");

				    response.setHeader("refresh", "3;url=login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
