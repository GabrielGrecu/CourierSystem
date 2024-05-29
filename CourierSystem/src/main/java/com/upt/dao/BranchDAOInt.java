package com.upt.dao;

import java.util.List;

import com.upt.dto.BranchDTO;

public interface BranchDAOInt {

	public long add(BranchDTO dto);

	public void delete(BranchDTO dto);

	public BranchDTO findBypk(long pk);

	public void update(BranchDTO dto);

	public List<BranchDTO> list();

	public List<BranchDTO> list(int pageNo, int pageSize);

	public List<BranchDTO> search(BranchDTO dto);

	public List<BranchDTO> search(BranchDTO dto, int pageNo, int pageSize);
}
