package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.entity.flightentity;
import com.plane.entity.userentity;
import com.plane.impdao.userdaoimp;

public class Finduserbyname extends HttpServlet {

	public Finduserbyname() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = (String)request.getSession().getAttribute("user");
		System.out.println("this is findusesrbyname "+ user);
		//根据用户名查询用户信息,通过session返回
		 userdaoimp os = new userdaoimp();
		 userentity person = new userentity();
		 try {
			person = os.finduserbyname(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("person", person);
		System.out.println(person.getIdentifyid());
		request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
	}

}
