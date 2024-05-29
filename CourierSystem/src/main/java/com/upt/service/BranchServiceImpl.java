package com.upt.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upt.dao.BranchDAOInt;
import com.upt.dto.BranchDTO;
import com.upt.exception.DuplicateRecordException;

@Service
public class BranchServiceImpl implements BranchServiceInt {

	private static Logger log = Logger.getLogger(BranchServiceImpl.class.getName());

	@Autowired
	private BranchDAOInt dao;

	@Override
	@Transactional
	public long add(BranchDTO dto) throws DuplicateRecordException {
		log.info("BranchServiceImpl Add method start");
		long pk = dao.add(dto);
		log.info("BranchServiceImpl Add method end");
		return pk;
	}

	

	@Override
	public List<BranchDTO> list() {
		log.info("BranchServiceImpl list method start");
		List<BranchDTO> list = dao.list();
		log.info("BranchServiceImpl list method end");
		return list;
	}

	@Override
	public List<BranchDTO> list(int pageNo, int pageSize) {
		log.info("BranchServiceImpl list method start");
		List<BranchDTO> list = dao.list(pageNo, pageSize);
		log.info("BranchServiceImpl list method end");
		return list;
	}

	@Override
	public List<BranchDTO> search(BranchDTO dto) {
		log.info("BranchServiceImpl search method start");
		List<BranchDTO> list = dao.search(dto);
		log.info("BranchServiceImpl search method end");
		return list;
	}

	@Override
	public List<BranchDTO> search(BranchDTO dto, int pageNo, int pageSize) {
		log.info("BranchServiceImpl search method start");
		List<BranchDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("BranchServiceImpl search method end");
		return list;
	}



	@Override
	@Transactional
	public void delete(BranchDTO dto) {
		log.info("BranchServiceImpl delete method start");
		dao.delete(dto);
		log.info("BranchServiceImpl delete method end");
	}



	@Override
	public BranchDTO findBypk(long pk) {
		log.info("BranchServiceImpl findBypk method start");
		BranchDTO dto = dao.findBypk(pk);
		log.info("BranchServiceImpl findBypk method end");
		return dto;
	}



	@Override
	@Transactional
	public void update(BranchDTO dto) throws DuplicateRecordException {
		dao.update(dto);
	}



	
	
	
}
