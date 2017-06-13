package com.plane.entity;

import java.sql.Time;


public class flightentity {
	@Override
	public String toString() {
		return "flightentity [arrivetime=" + arrivetime + ", company="
				+ company + ", end=" + end + ", flightid=" + flightid
				+ ", flytime=" + flytime + ", price=" + price + ", restseat="
				+ restseat + ", seatnum=" + seatnum + ", start=" + start
				+ ", time=" + time + "]";
	}

	private int flightid;
	private String start;
	private String end;
	private Time time;
	private Time flytime;
	private Time arrivetime;
	private int seatnum;
	private int restseat;
	private int price;
	private String company;
	
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Time getFlytime() {
		return flytime;
	}
	public void setFlytime(Time flytime) {
		this.flytime = flytime;
	}
	public Time getArrivetime() {
		return arrivetime;
	}
	public void setArrivetime(Time arrivetime) {
		this.arrivetime = arrivetime;
	}
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	public int getRestseat() {
		return restseat;
	}
	public void setRestseat(int restseat) {
		this.restseat = restseat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public flightentity(int flightid,String start,String end,Time time,Time flytime,Time arrivetime,
			int seatnum,int restseat,int price,String company){
		super();
		this.flightid=flightid;
		this.start=start;
		this.end=end;
		this.time=time;
		this.flytime=flytime;
		this.arrivetime=arrivetime;
		this.seatnum=seatnum;
		this.restseat=restseat;
		this.price=price;
		this.company=company;
	}
	
	public flightentity(){
		super();
	}

}
