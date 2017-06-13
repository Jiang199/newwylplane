package com.plane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.plane.util.RSAUtil;

public class RSAservlet extends HttpServlet {


	public RSAservlet() {
		super();
	}


    /**
     * ���ɹ�˽Կ����Կ����jsp
     * 
     * @param request
     */
    public void makeKV(HttpServletRequest request) {
        try {
        	//������Կ��
            KeyPair kp = RSAUtil.generateKeyPair();
            RSAPublicKey rsap = (RSAPublicKey) kp.getPublic();
            String module = rsap.getModulus().toString(16);
            String empoent = rsap.getPublicExponent().toString(16);

            // ˽Կ����session
            HttpSession hs = request.getSession();
            hs.setAttribute("privKey", kp.getPrivate());

            System.out.println("module:" + module);
            System.out.println("empoent:" + empoent);
            request.setAttribute("m", module);
            request.setAttribute("e", empoent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // get ����ҳ�棬ֻ��ʼ����˽Կ
        makeKV(request);
        System.out.println("��һ�����󣬷��ع�Կ");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // post �ύ��¼����
        try {
        	

            // ��session�л�ȡ˽Կ
            HttpSession hs = request.getSession();
            RSAPrivateKey privKey = (RSAPrivateKey) hs.getAttribute("privKey");

            // ����
            String pwd = request.getParameter("pwd");
            System.out.println("��ȡ������"+pwd);
            byte[] en_result = new BigInteger(pwd, 16).toByteArray();
            byte[] de_result = RSAUtil.decrypt(privKey, en_result);

            StringBuffer sb = new StringBuffer();
            sb.append(new String(de_result));
            pwd = sb.reverse().toString();

            // ��Ϊǰ̨js�Ѿ�����������md5�����Դ˴����ܺ�ֻ�ǻmd5
            // ��ע�⼸�㣬���ǰ̨js���ܵ����������ģ����ܻ����쳣����������ñ�ķ�ʽencode
            System.out.println("pwd(md5):" + pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        makeKV(request);

        request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
