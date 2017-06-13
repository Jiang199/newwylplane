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

		//��ú����
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("Id");
		System.out.println(id);
		//����û���
		String user = (String)request.getSession().getAttribute("user");
		System.out.println(user);
		//�����û����ͺ���ţ�ɾ������
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
			response.getWriter().write("��Ʊ�ɹ���3�����ת�û��������ģ�");
	        response.setHeader("refresh", "3;url=info.jsp");
	        return;
		}
	}

}
