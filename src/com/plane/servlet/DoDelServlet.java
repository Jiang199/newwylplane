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
		//ֱ�Ӹ��ݺ����ɾ���ú���
		int i = 0;
		flightdaoimp  dao = new flightdaoimp();
		i = dao.deleteoneflight(flightid);
		//��תҳ��
		if(i>0)
		{
			response.getWriter().write("ɾ���ɹ���3�������������");
	        response.setHeader("refresh", "3;url=admin1.jsp");
	        return;
		}
	}

}
