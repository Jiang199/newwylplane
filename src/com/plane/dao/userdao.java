package com.plane.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import com.plane.entity.userentity;

public interface userdao {
	//方法的接口
	public Boolean addOneUser(userentity user) throws NoSuchAlgorithmException;//增加的方法接口
	public int deleteOneUser(int userId);//删除的方法接口
	public int updateOneUser(userentity user);//改的方法接口
	public userentity findOneUser(String userId);//查一个用户的方法接口
	public List<userentity> findAllUser();//查找所有用户的方法接口
	public boolean islogin(String id, String password);//用户是否登陆成功
	public boolean islogin(userentity user);//用户是否登陆成功
	public boolean buytickets(String username,String flightid) throws SQLException;//根据用户名买票
	
}
