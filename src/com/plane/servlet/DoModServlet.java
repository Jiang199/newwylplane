package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.entity.flightentity;
import com.plane.impdao.flightdaoimp;

public class DoModServlet extends HttpServlet {

	public DoModServlet() {
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
		response.setCharacterEncoding("utf-8");
		//�õ�����
		int flightid = Integer.parseInt(request.getParameter("flightid"));
		String start = request.getParameter("start");
		System.out.println("������ :"+start);
		String end = request.getParameter("end");
		 Time flytime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String flytime1 = request.getParameter("flytime"); 
		
		System.out.println("���׷�1"+flytime1);
		try {
			flytime = new Time(sdf.parse(flytime1).getTime());
			System.out.println("���׷�"+flytime);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String arrivetime1 = request.getParameter("arrivetime");
		SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
		System.out.println("���׷�1����ʱ��"+arrivetime1);
		Time arrivetime = null;
		try {
			arrivetime = new Time(sd.parse(arrivetime1).getTime());
			System.out.println("���׷�1����ʱ��"+arrivetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int restseat = Integer.parseInt(request.getParameter("restseat"));
		int price =Integer.parseInt(request.getParameter("price"));
		String company = request.getParameter("company");
		
		flightdaoimp os = new flightdaoimp();
		flightentity flight = new flightentity();
		flight.setFlightid(flightid);
		flight.setStart(start);
		flight.setEnd(end);
		flight.setFlytime(flytime);
		flight.setArrivetime(arrivetime);
		flight.setRestseat(restseat);
		flight.setPrice(price);
		flight.setCompany(company);
		//�������� 
		flightdaoimp dao = new flightdaoimp();
		int i = dao.updateOneflight(flight);
		//��תҳ��
		if(i>0)
		{
			response.getWriter().write("�޸ĳɹ���3�������������");
	        response.setHeader("refresh", "3;url=admin1.jsp");
	        return;
		}
		
		
	}

}
