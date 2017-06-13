package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.entity.flightentity;
import com.plane.entity.userentity;
import com.plane.impdao.flightdaoimp;

public class Selectallflights extends HttpServlet {

	public Selectallflights() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		userentity admin = new userentity();
		admin = (userentity) request.getSession().getAttribute("admin");
		
		//查出所有航班，添加到flights list里面
		flightdaoimp os =  new flightdaoimp();
		List<flightentity> allflights = new ArrayList<flightentity>();
		allflights = os.findAllFlight();
		request.setAttribute("allflights", allflights);
		request.getRequestDispatcher("/admin1.jsp").forward(request, response);
	}

}
