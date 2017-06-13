package com.plane.impdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.plane.dao.basedao;
import com.plane.dao.flightdao;
import com.plane.entity.PageBean;
import com.plane.entity.flightentity;

public class flightdaoimp extends basedao implements flightdao{

	
	public List<flightentity> findAllFlight() {
		//查找航班的所有信息
		List<flightentity> flights = new ArrayList<flightentity>();
		String sql = "select * from flight_t ";
		Connection conn = this.getConn();
		System.out.println("conn -------------------> "+conn);
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("fasdfasdfasd----------------"+rs);
			while(rs.next()){
				int flightid = rs.getInt(1);
				String start = rs.getString(2);
				String end = rs.getString(3);
				Time time = rs.getTime(4);
				Time flytime = rs.getTime(5);
				Time arrivetime = rs.getTime(6);
				int seatnum = rs.getInt(7);
				int restseat = rs.getInt(8);
				int price = rs.getInt(9);
				String company = rs.getString(10);
				flights.add(new flightentity(flightid,start,end,time,flytime,arrivetime,
						seatnum,restseat,price,company));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return flights;

	}

	public List<flightentity> findflightbyname(String start, String end) {
		//根据出发地和目的地查找需要的航班
		List<flightentity> allflight = new ArrayList<flightentity>();
		String sql = "select * from flight_t where start='"+start+"' and end='"+end+"'";
		Connection conn = this.getConn();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int flightid = rs.getInt(1);
				String start1 = rs.getString(2);
				String end1 = rs.getString(3);
				Time time = rs.getTime(4);
				Time flytime = rs.getTime(5);
				Time arrivetime = rs.getTime(6);
				int seatnum = rs.getInt(7);
				int restseat = rs.getInt(8);
				int price = rs.getInt(9);
				String company = rs.getString(10);
				allflight.add(new flightentity(flightid,start1,end1,time,flytime,arrivetime,
						seatnum,restseat,price,company));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return allflight;
	}

	public List<flightentity> findflight() {
		List<flightentity> allflights = new ArrayList<flightentity>();
		String sql = "select * from flight_t ";
		Connection conn = this.getConn();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int flightid = rs.getInt(1);
				String start1 = rs.getString(2);
				String end1 = rs.getString(3);
				Time time = rs.getTime(4);
				Time flytime = rs.getTime(5);
				Time arrivetime = rs.getTime(6);
				int seatnum = rs.getInt(7);
				int restseat = rs.getInt(8);
				int price = rs.getInt(9);
				String company = rs.getString(10);
				allflights.add(new flightentity(flightid,start1,end1,time,flytime,arrivetime,
						seatnum,restseat,price,company));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return allflights;
		
	}

	public flightentity findoneflight(String flightid) throws SQLException {
		// 根据航班号，查找航班信息
		String sql = "select * from flight_t where flight_id='"+flightid+"' ";
		Connection conn = this.getConn();
		Statement stmt = conn.createStatement();
		flightentity flight =null;
		ResultSet rs = stmt.executeQuery(sql);
		//多个用户的时候需要用while，一个用户，只需要if
		if(rs.next()){
			int flightid1 = rs.getInt(1);
			String start = rs.getString(2);
			String end = rs.getString(3);
			Time time = rs.getTime(4);
			Time flytime = rs.getTime(5);
			Time arrivetime = rs.getTime(6);
			int seatnum = rs.getInt(7);
			int restseat = rs.getInt(8);
			int price = rs.getInt(9);
			String company = rs.getString(10);
			flight = new flightentity(flightid1,start,end,time,flytime,arrivetime,
					seatnum,restseat,price,company);
		}
		return flight;
	}

	public int updateOneflight(flightentity flight) {
		// 更新一个航班
		int i = 0;
		String sql = "update flight_t set start=?,end=?,fly_time=?,arrive_time=?,rest_seat=?,price=?,company=? where flight_id="
			+ flight.getFlightid();
	Connection cnn = this.getConn();
	try {
		PreparedStatement preStmt = cnn.prepareStatement(sql);
		preStmt.setString(1, flight.getStart());
		preStmt.setString(2, flight.getEnd());
		preStmt.setTime(3, flight.getFlytime());
		preStmt.setTime(4, flight.getArrivetime());
		preStmt.setInt(5, flight.getRestseat());
		preStmt.setInt(6, flight.getPrice());
		preStmt.setString(7, flight.getCompany());
		i = preStmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return i;
	}

	public int deleteoneflight(String flightid) {
		// 删除一列航班
		int i = 0;
		String sql = "delete from flight_t where flight_id=" + flightid;
		Connection cnn = this.getConn();
		try {
			Statement stmt = cnn.createStatement();
			i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public PageBean findflightpage(int currentpage, int pagesize) {
		
		flightdaoimp flightdao = new flightdaoimp();
		int count = flightdao.findAllFlight().size();//得到航班总记录数
		System.out.println("航班总数"+count);
		int totalPage = (int)Math.ceil(count*1.0/pagesize); //求出总页数
		List<flightentity> flights = flightdao.findflights((currentpage-1)*pagesize,pagesize);
		
		//把5个变量封装到PageBean中，做为返回值
		PageBean pb = new PageBean();
		pb.setFlights(flights);
		pb.setCount(count);
		pb.setCurrentPage(currentpage);
		pb.setPageSize(pagesize);
		pb.setTotalPage(totalPage);
		return pb;
		
	}

	private List<flightentity> findflights(int currentpage, int pagesize) {
		List<flightentity> flights = new ArrayList<flightentity>();
		String sql = "select * from flight_t limit ?,?";
		Connection conn = this.getConn();
		try {
			PreparedStatement preStmt = conn.prepareStatement(sql);
			System.out.println(currentpage+"current pagesize"+pagesize);
		
			preStmt.setInt(1,currentpage);
			preStmt.setInt(2,pagesize);
			System.out.println("到底sql是什么"+sql);
			ResultSet rs = preStmt.executeQuery();
			System.out.println(rs.toString());
			while(rs.next()){
				int flightid = rs.getInt(1);
				String start1 = rs.getString(2);
				String end1 = rs.getString(3);
				Time time = rs.getTime(4);
				Time flytime = rs.getTime(5);
				Time arrivetime = rs.getTime(6);
				int seatnum = rs.getInt(7);
				int restseat = rs.getInt(8);
				int price = rs.getInt(9);
				String company = rs.getString(10);
				flights.add(new flightentity(flightid,start1,end1,time,flytime,arrivetime,
						seatnum,restseat,price,company));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(flights.size()+"////"+flights.toString());
		return flights;
		
	}

	

}
