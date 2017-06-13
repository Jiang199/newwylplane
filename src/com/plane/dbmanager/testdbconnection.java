package com.plane.dbmanager;



public class testdbconnection {
	//检验数据库连接
	public static void main(String[] args) {
		dbconnection DB = new dbconnection();
		System.out.println(DB.getConn());
	}
}
