package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.entity.userentity;
import com.plane.impdao.userdaoimp;
import com.plane.util.Encodingbymd5;
import com.sun.org.apache.commons.beanutils.BeanUtils;

import org.apache.*;
public class Modifyuserservlet extends HttpServlet {

	public Modifyuserservlet() {
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
		userentity p = new userentity();
		String pwd = request.getParameter("pwd");
		System.out.println("修改后的密码为（不加密下）"+pwd);
		Encodingbymd5 md5 = new Encodingbymd5();
		String passwd=null;
		try {
			passwd = md5.encodeByMD5(pwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("修改后的密码为(加密后)"+passwd);
		String user = (String)request.getSession().getAttribute("user");
		int i = 0;
		userdaoimp os = new userdaoimp();
		i = os.modiifyuser(passwd,user);
		if(i>0){
			response.getWriter().write("修改成功，3秒后跳转登陆页面！");
			//request.getRequestDispatcher("/pageservlet").forward(request, response);
		    response.setHeader("refresh", "3;url=pageservlet");
		}
		
	}

}
