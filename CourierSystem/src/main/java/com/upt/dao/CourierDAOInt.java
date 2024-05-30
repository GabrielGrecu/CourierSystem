package com.upt.dao;

import java.util.List;

import com.upt.dto.CourierDTO;

public interface CourierDAOInt {

	long add(CourierDTO dto);

	void delete(CourierDTO dto);

	CourierDTO findBypk(long pk);
	
	Long generateTrackingNumber();

	void update(CourierDTO dto);

	List<CourierDTO> list();

	List<CourierDTO> list(int pageNo, int pageSize);

	List<CourierDTO> search(CourierDTO dto);

	List<CourierDTO> search(CourierDTO dto, int pageNo, int pageSize);
}
