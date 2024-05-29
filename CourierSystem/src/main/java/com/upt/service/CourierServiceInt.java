package com.upt.service;

import java.util.List;

import com.upt.dto.CourierDTO;

public interface CourierServiceInt {

	public long add(CourierDTO dto);

	public void delete(CourierDTO dto);

	public CourierDTO findBypk(long pk);
	
	public Long generateTrackingNumber();

	public void update(CourierDTO dto);

	public List<CourierDTO> list();

	public List<CourierDTO> list(int pageNo, int pageSize);

	public List<CourierDTO> search(CourierDTO dto);

	public List<CourierDTO> search(CourierDTO dto, int pageNo, int pageSize);
	
}
