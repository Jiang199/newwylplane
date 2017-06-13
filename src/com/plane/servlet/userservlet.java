package com.plane.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.plane.entity.userentity;
import com.plane.impdao.userdaoimp;
import com.plane.util.RSAUtil;

public class userservlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	/**
	 * Constructor of the object.
	 */
	public userservlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//这句话很重要，表明接受页面传来的数据是utf-8编码，不然会出现乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String s = request.getParameter("action");
		int action = Integer.parseInt(s);
		/*
		 * 3:显示查询结果
		 * 2:用户登录验证
		 * 1:提交注册信息
		 */ 
		
		switch (action) {
		case 1:
			String name = request.getParameter("username");
			
			System.out.print("看看接受的是不是中文 "+name);
			String pwd = request.getParameter("password");
			String identifyid = request.getParameter("identifyid");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			if(name==null||pwd==null||identifyid==null||age==null||sex==null){
				response.getWriter().write("信息没有填完整");
		        response.setHeader("refresh", "2;url=register.jsp");
				return;
			}
			if(sex.equals("1"))
			{
				sex="男";
			}else
			{
				sex="女";
			}
			userentity user= new userentity();
			user.setName(name);
			user.setPwd(pwd);
			user.setIdentifyid(identifyid);
			user.setAge(age);
			user.setSex(sex);
			userdaoimp dao = new userdaoimp();
			try {
				if(dao.addOneUser(user))
				{
					request.getRequestDispatcher("/rsaservlet").forward(request,response);
					
				}else{
					System.out.println("注册失败");
				}
			} catch (NoSuchAlgorithmException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case 2:
			//用户登陆
			
			// 从session中获取私钥
            HttpSession hs = request.getSession();
            RSAPrivateKey privKey = (RSAPrivateKey) hs.getAttribute("privKey");
            
            // 解密
            byte[] de_result=null;
            String passwd = request.getParameter("pwd");
            System.out.println("获取的密码"+passwd);
            byte[] en_result = new BigInteger(passwd, 16).toByteArray();
            System.out.println("获取的密码转换成大写，16位，字节"+en_result);
            try {
				 de_result = RSAUtil.decrypt(privKey, en_result);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			StringBuffer sb = new StringBuffer();
            sb.append(new String(de_result));
            pwd = sb.reverse().toString();

            // 因为前台js已经把密码生成md5，所以此处解密后只是活动md5
            // 需注意几点，如果前台js加密的内容有中文，解密会有异常，需把中文用别的方式encode
            System.out.println("pwd(md5):" + pwd);
            
            //获取用户用户名
			String id = request.getParameter("id");
			System.out.println("用户名 "+id);
			
			
			String code = request.getParameter("code");
			String code1 = (String)request.getSession().getAttribute("validatecode");
			
			userdaoimp dao1 = new userdaoimp();
			//如果是admin用户直接跳转到管理员用户页面
			if("admin".equals(id))
			{
				
				userentity admin = new userentity();
				try {
					admin=dao1.findoneadmin("admin");
					System.out.println(admin.getName()+admin.getPwd());
					if(admin !=null){				
						request.getSession().setAttribute("admin", admin);
						response.sendRedirect(request.getContextPath()+"/admin.jsp");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				return;
			}
			
			System.out.println("输进去的用户名为"+id+"输入进去，加密后的密码为"+pwd);
			System.out.println("判断验证码是否相等"+code1.equals(code));
			System.out.println("判断dao1.islogin(id, pwd)"+dao1.islogin(id, pwd));
			System.out.println("判断用户名，密码，验证码是否为正确"+(dao1.islogin(id, pwd)&&code1.equals(code)));
			//检查loginstate状态位是否为0 。如果为0，表示可以登陆，如果为1，返回消息，正在登陆中
			try {
				int  state1 = dao1.findloginstate(id);
				if(state1==1)
				{
					request.setAttribute("message","此账户正在登陆");
					System.out.println("此账户正在登陆");
					 request.getRequestDispatcher("rsaservlet").forward(request, response);
					//response.sendRedirect(request.getContextPath() + "/rsaservlet");
				}else if(dao1.islogin(id, pwd)&&code1.equals(code))
				{
					userentity user1= new userentity();
					user1 = dao1.findOneUser(id);
					HttpSession session = request.getSession();
					session.setAttribute("user", id);
					
					//登陆成功，修改数据库loginstate状态位，把0改为1，表示正在登陆
					//1表示ONLINE 0表示OFFLINE
					int i = dao1.modifystate(1,id);
					if(i>0)	//状态为修改成功
					{
						System.out.println("setsession!!!!"+session.getServletContext());
						System.out.println("登陆成功，跳转页面,验证码验证成功");
						request.getRequestDispatcher("/pageservlet").forward(request, response);
					}
				}
				else {
					request.setAttribute("message","用户名或密码错误");
					System.out.println("登陆出错");
					 request.getRequestDispatcher("rsaservlet").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			break;
		}
		
	}

}
