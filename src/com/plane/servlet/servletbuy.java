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
		//��ȡ����
		String name = request.getParameter("userid"); //��ù�����û���
		String flightid = request.getParameter("flightid");//��ȡ�����
		System.out.println("the name is !!! "+name);
		System.out.println("the flightid is !!!"+flightid);
		if(name==null){
			response.getWriter().write("�û�δ��½��3�����ת��½ҳ�棡");
	        response.setHeader("refresh", "3;url=login.jsp");
	        return;
		}else{
			//��������
			userdaoimp userdao = new userdaoimp();
			try {
				if(userdao.buytickets(name,flightid))
				{
					//����ɹ���ת������
					response.getWriter().write("��Ʊ�ɹ���3�����ת��ҳ��");

				    response.setHeader("refresh", "3;url=pageservlet");
				}
				else{
					//��Ʊʧ�ܣ�ת������
					response.getWriter().write("��Ʊʧ�ܣ�3�����ת��½ҳ�棡");

				    response.setHeader("refresh", "3;url=login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
