package com.upt.service;

import java.util.List;

import com.upt.dto.BranchDTO;
import com.upt.exception.DuplicateRecordException;

public interface BranchServiceInt {

	public long add(BranchDTO dto) throws DuplicateRecordException;
	
	public void delete(BranchDTO dto);
	
	public BranchDTO findBypk(long pk);

	public void update(BranchDTO dto) throws DuplicateRecordException;

	public List<BranchDTO> list();

	public List<BranchDTO> list(int pageNo, int pageSize);

	public List<BranchDTO> search(BranchDTO dto);

	public List<BranchDTO> search(BranchDTO dto, int pageNo, int pageSize);
	
}
