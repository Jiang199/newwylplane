package com.plane.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.entity.flightentity;
import com.plane.impdao.flightdaoimp;

public class Searchflight extends HttpServlet {

	public Searchflight() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		String start = request.getParameter("start");
		//String start=URLDecoder.decode(request.getParameter("start"),"utf-8");  
		String end = request.getParameter("end");
		System.out.println(start+"出发地  目的地"+end);
		flightdaoimp os =  new flightdaoimp();
		List<flightentity> allflight = null;
		allflight = os.findflightbyname("南京","北京");
		System.out.println("根据时间地点查到的航班为："+allflight.toString());
		request.setAttribute("allflight", allflight);
		request.getRequestDispatcher("/order2.jsp").forward(request, response);
	}

}
