package com.plane.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import com.plane.entity.userentity;

public interface userdao {
	//�����Ľӿ�
	public Boolean addOneUser(userentity user) throws NoSuchAlgorithmException;//���ӵķ����ӿ�
	public int deleteOneUser(int userId);//ɾ���ķ����ӿ�
	public int updateOneUser(userentity user);//�ĵķ����ӿ�
	public userentity findOneUser(String userId);//��һ���û��ķ����ӿ�
	public List<userentity> findAllUser();//���������û��ķ����ӿ�
	public boolean islogin(String id, String password);//�û��Ƿ��½�ɹ�
	public boolean islogin(userentity user);//�û��Ƿ��½�ɹ�
	public boolean buytickets(String username,String flightid) throws SQLException;//�����û�����Ʊ
	
}
