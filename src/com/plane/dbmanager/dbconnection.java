package com.plane.dbmanager;

import java.sql.*;
public class dbconnection {
	//连接数据库
	private String dbDriver = "com.mysql.jdbc.Driver";
	//这里useUnicode=true&characterEncoding=utf8&autoReconnect=true，需要指定，不然存进数据库会出现乱码
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
