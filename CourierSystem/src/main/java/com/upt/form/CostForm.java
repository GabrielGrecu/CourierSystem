package com.upt.form;

import javax.validation.constraints.NotNull;

import com.upt.dto.BaseDTO;
import com.upt.dto.CostDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CostForm extends BaseForm {

	@NotNull(message = "Cost is required")
	private Long cost1;
	@NotNull(message = "Cost is required")
	private Long cost2;
	
	@Override
	public BaseDTO getDTO() {
		CostDTO bean = new CostDTO();
		bean.setId(id);
		bean.setCost1(cost1);
		bean.setCost2(cost2);
		bean.setCreatedBy(createdBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedBy(modifiedBy);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		CostDTO bean = (CostDTO)bDto;
		id = bean.getId();
		cost1 = bean.getCost1();
		cost2 = bean.getCost2();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
