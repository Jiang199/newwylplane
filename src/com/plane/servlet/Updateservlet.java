package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.entity.flightentity;
import com.plane.impdao.flightdaoimp;

public class Updateservlet extends HttpServlet {

	public Updateservlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().getAttribute("admin");
		String flightid = request.getParameter("flightid");
		flightdaoimp os = new flightdaoimp();
		try {
			//根据航班号查找航班信息
			flightentity flight = (flightentity)os.findoneflight(flightid);
			System.out.println("需要修改的航班信息"+flight.toString());
			request.setAttribute("flightid", flight.getFlightid());
			request.setAttribute("start", flight.getStart());
			request.setAttribute("end", flight.getEnd());
			
			request.setAttribute("time", flight.getTime());
			request.setAttribute("flytime", flight.getFlytime());
			request.setAttribute("arrivetime", flight.getArrivetime());
			
			////////////////////时间转换////////
			System.out.println("吴云龙"+flight.getFlytime());
			
			////////////////////
			
			request.setAttribute("restseat",flight.getRestseat());
			request.setAttribute("price", flight.getPrice());
			request.setAttribute("company", flight.getCompany());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("modify.jsp").forward(request, response);
	}

}
