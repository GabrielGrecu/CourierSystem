package com.upt.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import com.upt.dao.CourierDAOInt;
import com.upt.dto.CourierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceImpl implements CourierServiceInt {

	private static Logger log = Logger.getLogger(CourierServiceImpl.class.getName());


	@Autowired
	private CourierDAOInt dao;

	@Override
	@Transactional
	public long add(CourierDTO dto) {
		log.info("CourierServiceImpl Add method start");
		long pk = dao.add(dto);
		log.info("CourierServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(CourierDTO dto) {
		dao.delete(dto);
	}

	@Override
	public CourierDTO findBypk(long pk) {
		log.info("CourierServiceImpl findBypk method start");
		CourierDTO dto = dao.findBypk(pk);
		log.info("CourierServiceImpl findBypk method end");
		return dto;
	}

	

	@Override
	@Transactional
	public void update(CourierDTO dto) {
			dao.update(dto);
	}

	@Override
	public List<CourierDTO> list() {
		log.info("CourierServiceImpl list method start");
		List<CourierDTO> list = dao.list();
		log.info("CourierServiceImpl list method end");
		return list;
	}

	@Override
	public List<CourierDTO> list(int pageNo, int pageSize) {
		log.info("CourierServiceImpl list method start");
		List<CourierDTO> list = dao.list(pageNo, pageSize);
		log.info("CourierServiceImpl list method end");
		return list;
	}

	@Override
	public List<CourierDTO> search(CourierDTO dto) {
		log.info("CourierServiceImpl search method start");
		List<CourierDTO> list = dao.search(dto);
		log.info("CourierServiceImpl search method end");
		return list;
	}

	@Override
	public List<CourierDTO> search(CourierDTO dto, int pageNo, int pageSize) {
		log.info("CourierServiceImpl search method start");
		List<CourierDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("CourierServiceImpl search method end");
		return list;
	}

	@Override
	public Long generateTrackingNumber() {
		return dao.generateTrackingNumber();
	}
}
