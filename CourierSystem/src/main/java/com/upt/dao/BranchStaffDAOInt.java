package com.upt.dao;

import java.util.List;

import com.upt.dto.BranchStaffDTO;

public interface BranchStaffDAOInt {

	public long add(BranchStaffDTO dto);

	public void delete(BranchStaffDTO dto);

	public BranchStaffDTO findBypk(long pk);
	
	public BranchStaffDTO findByUserId(long userId);

	public void update(BranchStaffDTO dto);

	public List<BranchStaffDTO> list();

	public List<BranchStaffDTO> list(int pageNo, int pageSize);

	public List<BranchStaffDTO> search(BranchStaffDTO dto);

	public List<BranchStaffDTO> search(BranchStaffDTO dto, int pageNo, int pageSize);
}
