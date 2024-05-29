package com.upt.service;

import com.upt.dto.CostDTO;

public interface CostServiceInt {

	Long add(CostDTO dto);

	Long calculatePrice(Long weight);

	CostDTO getCosts();
}
