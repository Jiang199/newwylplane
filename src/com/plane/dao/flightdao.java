package com.plane.dao;

import java.util.List;

import com.plane.entity.flightentity;

public interface flightdao {
	//航班的接口
	public List<flightentity> findAllFlight();//查找所有用户的方法接口
}
