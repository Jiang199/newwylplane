package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.impdao.userdaoimp;
import com.plane.entity.*;
public class FindOrderByUserId extends HttpServlet {
	public FindOrderByUserId() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String  user = (String)request.getSession().getAttribute("user");
		 System.out.println("///////////"+user);
		 //根据用户名查询航班放进list
		 userdaoimp os = new userdaoimp();
		 List<flightentity> flights = null;
		try {
			flights = os.findorderbyuserid(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("flights", flights);
		 request.setAttribute("count", flights.size());
		 request.getRequestDispatcher("/flightlist.jsp").forward(request, response);
	}

}
