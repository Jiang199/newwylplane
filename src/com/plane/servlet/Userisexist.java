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
		//���������
        PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		System.out.println("Ҫע����û��� Ϊ"+username);
		userdaoimp  dao = new userdaoimp();
		boolean  isuser;
		try {
			isuser = dao.isexist(username); //����true���ǿ���ע�ᣬ����false���ǲ�����ע��
			if(isuser==true){
				out.print("<font color='green'>������ע����û���</font>");
			}else{
				out.print("<font color='red'>�û����ѱ�ע��</font> ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			//request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

}
