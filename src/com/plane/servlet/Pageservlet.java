package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plane.entity.PageBean;
import com.plane.entity.flightentity;
import com.plane.impdao.flightdaoimp;

public class Pageservlet extends HttpServlet {

	public Pageservlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//初始化每页显示的记录数
		int pagesize = 4;
		
		int currentpage=1;
		
		String currpage = request.getParameter("currentpage");
		System.out.println("当前页为：第"+currpage);
		
	//	if("".equals(currpage)||currpage.length()==0)
		if(null==currpage)
		{
			currentpage=1;
		}else{
			currentpage = Integer.parseInt(currpage);
			if(currentpage<=0)
				currentpage=1;
		}
		//if(currpage!=null){//第一次访问资源时，currPage可能是null
			//currentpage = Integer.parseInt(currpage);
			//if(currpage.length()<=0||currentpage<=0){
			//	currentpage=1;
			//}
			//if(Boolean.parseBoolean(currpage))
			//{
			//	currentpage=1;
			//}else{
			//	currentpage=Integer.parseInt(currpage);
			//}
			
			
		//}
		flightdaoimp os =  new flightdaoimp();
		//分页查询，并返回PageBean对象
		PageBean pb = os.findflightpage(currentpage,pagesize);
		
		request.setAttribute("pb", pb);
		
		request.getRequestDispatcher("/order1.jsp").forward(request, response);
	}

}
