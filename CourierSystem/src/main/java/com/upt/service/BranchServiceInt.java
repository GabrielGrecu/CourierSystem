package com.upt.service;

import java.util.List;

import com.upt.dto.BranchDTO;
import com.upt.exception.DuplicateRecordException;

public interface BranchServiceInt {

	long add(BranchDTO dto) throws DuplicateRecordException;
	
	void delete(BranchDTO dto);
	
	BranchDTO findBypk(long pk);

	void update(BranchDTO dto) throws DuplicateRecordException;

	List<BranchDTO> list();

	List<BranchDTO> list(int pageNo, int pageSize);

	List<BranchDTO> search(BranchDTO dto);

	List<BranchDTO> search(BranchDTO dto, int pageNo, int pageSize);
	
}
