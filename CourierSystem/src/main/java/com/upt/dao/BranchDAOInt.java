package com.upt.dao;

import java.util.List;

import com.upt.dto.BranchDTO;

public interface BranchDAOInt {

	long add(BranchDTO dto);

	void delete(BranchDTO dto);

	BranchDTO findBypk(long pk);

	void update(BranchDTO dto);

	List<BranchDTO> list();

	List<BranchDTO> list(int pageNo, int pageSize);

	List<BranchDTO> search(BranchDTO dto);

	List<BranchDTO> search(BranchDTO dto, int pageNo, int pageSize);
}
