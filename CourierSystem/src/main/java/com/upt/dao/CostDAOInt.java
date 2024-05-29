package com.upt.dao;

import com.upt.dto.CostDTO;

public interface CostDAOInt {

	Long add(CostDTO dto);

	Long calculatePrice(Long weight);

	CostDTO getCosts();
}
