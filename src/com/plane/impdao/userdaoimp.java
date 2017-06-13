package com.plane.impdao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.plane.dao.basedao;
import com.plane.dao.userdao;
import com.plane.entity.flightentity;
import com.plane.entity.userentity;
import com.plane.util.Encodingbymd5;



public class userdaoimp extends basedao implements userdao{

	
	//�����û�
	public Boolean addOneUser(userentity user) throws NoSuchAlgorithmException  {
		// TODO Auto-generated method stub
		Connection conn = this.getConn();
		String sql="insert into user(userName,userPass,age,sex,identify_id) values(?,?,?,?,?)";
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			Encodingbymd5 md5 = new Encodingbymd5();
			String passwd = md5.encodeByMD5(user.getPwd());
			pst.setString(2, passwd);			
			pst.setString(3, user.getAge());
			pst.setString(4, user.getSex());
			pst.setString(5, user.getIdentifyid());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{		
			//��ɺ�ر�
				try {
					if(pst!=null)
						pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(conn!=null)
					{
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return false;
	}

	//ɾ��һ���û�
	public int deleteOneUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<userentity> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	//����һ���û�
	public userentity findOneUser(String userId) {
		// TODO Auto-generated method stub
		Connection conn = this.getConn();
		String sql = "select * from user where userName=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			rs = pst.executeQuery(sql);
			if(rs.next())
			{
				userentity user = new userentity();
				user.setName(rs.getString("userName"));
				user.setPwd(rs.getString("userPass" ));
				user.setAge(rs.getString("age"));
				user.setSex(rs.getString("sex"));
				user.setIdentifyid(rs.getString("identify_id"));
				return user;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			//��ɺ�ر�
			try {
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	//�޸�һ���û�����
	public int updateOneUser(userentity user) {
		// TODO Auto-generated method stub
		return 0;
	}

	//�ж��û��Ƿ��½�ɹ�
	public boolean islogin(String id, String password) {
		// TODO Auto-generated method stub
		Connection conn = this.getConn();
		String sql = "select * from user where userName=? and userPass=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, password);
			System.out.println(pst);
			rs = pst.executeQuery();
			System.out.println("dao�㴦����ɣ���½rsִ�н��Ϊ"+rs);
			boolean p =rs.next();
			System.out.println("dao�㴦����ɣ���½rs.next()ִ�н��Ϊ"+p);
			
			if(p==true)
			{
				System.out.println("rs.next()Ϊtrue������true");
				return true;
			}else{
				System.out.println("rs.next()Ϊfalse������false");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			//��ɺ�ر�
			try {
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}

	//�ж��û��Ƿ��½�ɹ�
	public boolean islogin(userentity user) {
		// TODO Auto-generated method stub
		return false;
	}
	//�����û���������Ʊ
	public boolean buytickets(String username,String flightid) throws SQLException {
		//���Լ��˻������һ�ŷɻ�Ʊ
		Connection conn = this.getConn();
		String sql1 = "insert into map_t(username,flight_id) values(?,?)";
		String sql2 = "select rest_seat from flight_t where flight_id=?";//�����ǰ����Ʊ��
		String sql3 = "update flight_t set rest_seat=? where flight_id=? ";//�ں�������ȥƱ��
		PreparedStatement pst=null;
		ResultSet rs = null;
		try{
			//��map_t��������¹����Ʊ
			int rest_ticket = 0;
			pst=conn.prepareStatement(sql1);
			pst.setString(1, username);
			pst.setString(2, flightid);
			pst.executeUpdate();
			//��flight_t�в��ʣ��Ʊ��rest_ticket
			pst=conn.prepareStatement(sql2);
			pst.setString(1, flightid);
			rs = pst.executeQuery();
			if(rs.next())
			{
				String ticket_num = rs.getString(1);
				rest_ticket = Integer.parseInt(ticket_num);
				rest_ticket--;
			}
			//����ʣ��Ʊ���޸�
			pst=conn.prepareStatement(sql3);
			String s = Integer.toString(rest_ticket);
			pst.setString(1, s);
			pst.setString(2, flightid);
			pst.executeUpdate();
			
			return true;
		}catch(Exception e) {
			// TODO: handle exception
		} finally{
			//��ɺ�ر�
			try {
				if(pst!=null)
					pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	
	}

	public List<flightentity> findorderbyuserid(String user) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("this is findorderbyuserid");
		//�����û���id��ѯ���к���
		List<flightentity> flights = new ArrayList<flightentity>();
		Connection conn = this.getConn();
		String sql = "select * from flight_t where  flight_id in (SELECT flight_id from map_t where username= '" + user + "')";
		PreparedStatement pst = null;
		ResultSet rs = null;
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery(sql);
		System.out.println("sql is ////"+pst);
		while(rs.next())
		{
			flightentity flight = new flightentity();
			flight.setFlightid(rs.getInt(1));
			flight.setStart(rs.getString(2));
			flight.setEnd(rs.getString(3));
			flight.setTime(rs.getTime(4));
			flight.setFlytime(rs.getTime(5));
			flight.setArrivetime(rs.getTime(6));
			flight.setPrice(rs.getInt(9));
			flight.setCompany(rs.getString(10));
			flights.add(flight);
		}
		return flights;
	}
	//ɾ��Ʊ����Ʊ����
	public int deleteorder(String id, String user) throws SQLException {
		int i = 0;
		String sql = "delete from map_t where username='"+user+"' and flight_id='"+id+"'";
		Connection conn = this.getConn();
		PreparedStatement pst = null;
		pst = conn.prepareStatement(sql);
		System.out.println(pst);
		i = pst.executeUpdate(sql);
		return i;
	}

	public userentity finduserbyname(String user) throws SQLException {
		//�����û��������û���Ϣ�������û�����
		Connection conn = this.getConn();
		String sql = "select * from user where userName='"+user+"'";
		userentity person = new userentity();
		PreparedStatement pst = null;
		ResultSet rs = null;
		pst = conn.prepareStatement(sql);
		System.out.println(pst);
		rs = pst.executeQuery(sql);
		if(rs.next())
		{
			
			person.setName(rs.getString(2));
			person.setPwd(rs.getString(3));
			person.setAge(rs.getString(4));
			person.setSex(rs.getString(5));
			person.setIdentifyid(rs.getString(6));
		}
		return person;
	}

	public int modiifyuser(String pwd,String user) {
		// �޸��û���Ϣ
		Connection conn = this.getConn();
		int i = 0;
		String sql = "update user set userPass='"+pwd+"'  where userName='"+user+"'";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			i = pst.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//���ҹ���Ա��Ϣ
	public userentity findoneadmin(String admin) throws SQLException {
		Connection conn = this.getConn();
		String sql = "select * from admin_t where userName='"+admin+"'";
		userentity person = new userentity();
		PreparedStatement pst = null;
		ResultSet rs = null;
		pst = conn.prepareStatement(sql);
		System.out.println(pst);
		rs = pst.executeQuery(sql);
		if(rs.next())
		{
			
			person.setName(rs.getString(2));
			person.setPwd(rs.getString(3));
		}
		
		return person;
		
	}

	public int modifystate(int i,String id) {
		// �޸ĵ�½״̬λ ��i ���Ϊ0 ��ʾOFFLINE ,1��ʾONLINE
		//id��ʾ��Ҫ�޸ĵ��û���
		Connection conn = this.getConn();
		int state = 0;
		String sql = "update user set loginstate='"+i+"'  where userName='"+id+"' ";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			state = pst.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
		
	}

	public int findloginstate(String id) throws SQLException {
		Connection conn = this.getConn();
		String sql = "select loginstate from user where userName='"+id+"'";
		PreparedStatement pst = null;
		ResultSet rs = null;
		pst = conn.prepareStatement(sql);
		System.out.println(pst);
		rs = pst.executeQuery(sql);
		int value=0;
		if(rs.next())
		{	
			value = rs.getInt(1);
		}
		System.out.println("״̬λ����ֵvalueΪ------->"+value);
		return value;
	}

	//����ע���û����Ƿ��Ѿ�����
	public boolean isexist(String username) throws SQLException {
		Connection conn = this.getConn();
		String sql = "select userName from user where userName='"+username+"'";
		PreparedStatement pst = null;
		ResultSet rs = null;
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery(sql);
		if(rs.next())
		{
			return false;
		}
		return true;
	}
	
}
