package com.plane.dbmanager;

import java.sql.*;
public class dbconnection {
	//�������ݿ�
	private String dbDriver = "com.mysql.jdbc.Driver";
	//����useUnicode=true&characterEncoding=utf8&autoReconnect=true����Ҫָ������Ȼ������ݿ���������
	private String dbUrl = "jdbc:mysql://localhost:3306/man?useUnicode=true&characterEncoding=utf8&autoReconnect=true";
	private String dbUser ="root";
	private String dbPass ="wuyunlong";
	
	public Connection getConn()
	{
		Connection conn = null;
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			 conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}

	
}
