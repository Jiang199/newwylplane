package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plane.impdao.userdaoimp;

public class Logout extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Logout() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	    HttpSession session=request.getSession(false);  
        if(session==null){  
            response.sendRedirect("one.jsp");  
            return;  
        }  
        //先把loginstate状态为修改掉
        userdaoimp  dao = new userdaoimp();
        String id = (String)session.getAttribute("user");
        dao.modifystate(0, id);
        session.removeAttribute("user");  
        response.sendRedirect("one.jsp");  
		
	}

}
