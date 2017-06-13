package com.plane.entity;

import java.util.List;

public class PageBean {
	
	private int pageSize;
	private int count;
	private int totalPage;
	private List<flightentity> flights;
	private int currentPage;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getCount() {
		return count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public List<flightentity> getFlights() {
		return flights;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setFlights(List<flightentity> flights) {
		this.flights = flights;
	}

}
