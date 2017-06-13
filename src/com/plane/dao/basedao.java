package com.plane.dao;

import java.sql.*;

import com.plane.dbmanager.*;

public class basedao {
	Connection conn =null;
	public Connection getConn(){
		dbconnection db = new dbconnection();
		conn  = db.getConn();
		System.out.println("basedao----------=========++++++"+conn);
		return conn;
	}
}
