package com.upt.service;

import java.util.List;

import com.upt.dto.BranchStaffDTO;
import com.upt.exception.DuplicateRecordException;

public interface BranchSatffServiceInt {

	long add(BranchStaffDTO dto) throws DuplicateRecordException;

	void delete(BranchStaffDTO dto);

	BranchStaffDTO findBypk(long pk);
	
	BranchStaffDTO findByUserId(long userId);

	void update(BranchStaffDTO dto) throws DuplicateRecordException;

	List<BranchStaffDTO> list();

	List<BranchStaffDTO> list(int pageNo, int pageSize);

	List<BranchStaffDTO> search(BranchStaffDTO dto);

	List<BranchStaffDTO> search(BranchStaffDTO dto, int pageNo, int pageSize);

}
