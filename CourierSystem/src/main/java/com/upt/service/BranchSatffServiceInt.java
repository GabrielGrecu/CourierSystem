package com.upt.service;

import java.util.List;

import com.upt.dto.BranchStaffDTO;
import com.upt.exception.DuplicateRecordException;

public interface BranchSatffServiceInt {

	public long add(BranchStaffDTO dto) throws DuplicateRecordException;

	public void delete(BranchStaffDTO dto);

	public BranchStaffDTO findBypk(long pk);
	
	public BranchStaffDTO findByUserId(long userId);

	public void update(BranchStaffDTO dto) throws DuplicateRecordException;

	public List<BranchStaffDTO> list();

	public List<BranchStaffDTO> list(int pageNo, int pageSize);

	public List<BranchStaffDTO> search(BranchStaffDTO dto);

	public List<BranchStaffDTO> search(BranchStaffDTO dto, int pageNo, int pageSize);

}
