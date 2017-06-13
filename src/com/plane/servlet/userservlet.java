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
		//��仰����Ҫ����������ҳ�洫����������utf-8���룬��Ȼ���������
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String s = request.getParameter("action");
		int action = Integer.parseInt(s);
		/*
		 * 3:��ʾ��ѯ���
		 * 2:�û���¼��֤
		 * 1:�ύע����Ϣ
		 */ 
		
		switch (action) {
		case 1:
			String name = request.getParameter("username");
			
			System.out.print("�������ܵ��ǲ������� "+name);
			String pwd = request.getParameter("password");
			String identifyid = request.getParameter("identifyid");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			if(name==null||pwd==null||identifyid==null||age==null||sex==null){
				response.getWriter().write("��Ϣû��������");
		        response.setHeader("refresh", "2;url=register.jsp");
				return;
			}
			if(sex.equals("1"))
			{
				sex="��";
			}else
			{
				sex="Ů";
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
					System.out.println("ע��ʧ��");
				}
			} catch (NoSuchAlgorithmException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case 2:
			//�û���½
			
			// ��session�л�ȡ˽Կ
            HttpSession hs = request.getSession();
            RSAPrivateKey privKey = (RSAPrivateKey) hs.getAttribute("privKey");
            
            // ����
            byte[] de_result=null;
            String passwd = request.getParameter("pwd");
            System.out.println("��ȡ������"+passwd);
            byte[] en_result = new BigInteger(passwd, 16).toByteArray();
            System.out.println("��ȡ������ת���ɴ�д��16λ���ֽ�"+en_result);
            try {
				 de_result = RSAUtil.decrypt(privKey, en_result);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			StringBuffer sb = new StringBuffer();
            sb.append(new String(de_result));
            pwd = sb.reverse().toString();

            // ��Ϊǰ̨js�Ѿ�����������md5�����Դ˴����ܺ�ֻ�ǻmd5
            // ��ע�⼸�㣬���ǰ̨js���ܵ����������ģ����ܻ����쳣����������ñ�ķ�ʽencode
            System.out.println("pwd(md5):" + pwd);
            
            //��ȡ�û��û���
			String id = request.getParameter("id");
			System.out.println("�û��� "+id);
			
			
			String code = request.getParameter("code");
			String code1 = (String)request.getSession().getAttribute("validatecode");
			
			userdaoimp dao1 = new userdaoimp();
			//�����admin�û�ֱ����ת������Ա�û�ҳ��
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
			
			System.out.println("���ȥ���û���Ϊ"+id+"�����ȥ�����ܺ������Ϊ"+pwd);
			System.out.println("�ж���֤���Ƿ����"+code1.equals(code));
			System.out.println("�ж�dao1.islogin(id, pwd)"+dao1.islogin(id, pwd));
			System.out.println("�ж��û��������룬��֤���Ƿ�Ϊ��ȷ"+(dao1.islogin(id, pwd)&&code1.equals(code)));
			//���loginstate״̬λ�Ƿ�Ϊ0 �����Ϊ0����ʾ���Ե�½�����Ϊ1��������Ϣ�����ڵ�½��
			try {
				int  state1 = dao1.findloginstate(id);
				if(state1==1)
				{
					request.setAttribute("message","���˻����ڵ�½");
					System.out.println("���˻����ڵ�½");
					 request.getRequestDispatcher("rsaservlet").forward(request, response);
					//response.sendRedirect(request.getContextPath() + "/rsaservlet");
				}else if(dao1.islogin(id, pwd)&&code1.equals(code))
				{
					userentity user1= new userentity();
					user1 = dao1.findOneUser(id);
					HttpSession session = request.getSession();
					session.setAttribute("user", id);
					
					//��½�ɹ����޸����ݿ�loginstate״̬λ����0��Ϊ1����ʾ���ڵ�½
					//1��ʾONLINE 0��ʾOFFLINE
					int i = dao1.modifystate(1,id);
					if(i>0)	//״̬Ϊ�޸ĳɹ�
					{
						System.out.println("setsession!!!!"+session.getServletContext());
						System.out.println("��½�ɹ�����תҳ��,��֤����֤�ɹ�");
						request.getRequestDispatcher("/pageservlet").forward(request, response);
					}
				}
				else {
					request.setAttribute("message","�û������������");
					System.out.println("��½����");
					 request.getRequestDispatcher("rsaservlet").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			break;
		}
		
	}

}
