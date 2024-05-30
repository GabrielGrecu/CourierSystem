package com.upt.dao;

import java.util.List;

import com.upt.dto.BranchStaffDTO;

public interface BranchStaffDAOInt {

	long add(BranchStaffDTO dto);

	void delete(BranchStaffDTO dto);

	BranchStaffDTO findBypk(long pk);
	
	BranchStaffDTO findByUserId(long userId);

	void update(BranchStaffDTO dto);

	List<BranchStaffDTO> list();

	List<BranchStaffDTO> list(int pageNo, int pageSize);

	List<BranchStaffDTO> search(BranchStaffDTO dto);

	List<BranchStaffDTO> search(BranchStaffDTO dto, int pageNo, int pageSize);
}
