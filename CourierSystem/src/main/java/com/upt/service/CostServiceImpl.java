package com.upt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upt.dao.CostDAOInt;
import com.upt.dto.CostDTO;

@Service
public class CostServiceImpl implements CostServiceInt {

	@Autowired
	private CostDAOInt dao;

	@Override
	public Long add(CostDTO dto) {
		Long pk = dao.add(dto);
		return pk;
	}

	@Override
	public Long calculatePrice(Long weight) {
		Long pk = dao.calculatePrice(weight);
		return pk;
	}

	@Override
	public CostDTO getCosts() {
		CostDTO bean = dao.getCosts();
		return bean;
	}

}
