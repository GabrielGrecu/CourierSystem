package com.upt.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.upt.dto.BaseDTO;
import com.upt.dto.BranchDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BranchForm extends BaseForm {
	
	@NotEmpty(message = "Street is required")
	private String street;
	@NotEmpty(message = "City is required")
	private String city;
	@NotEmpty(message = "State is required")
	private String state;
	@NotEmpty(message = "Zip Code is required")
	@Pattern(regexp="(^[0-9]*$)",message = "Zip Code is Invalid")
	private String zipCode;
	@NotEmpty(message = "Country is required")
	private String country;
	@NotEmpty(message = "Contact Number is required")
	@Pattern(regexp="(^07[0-9]{8})*$",message = "Contact Number is Invalid")
	private String contact;
	
	private String fullBranchName;
	@Override
	public BaseDTO getDTO() {
		BranchDTO bean = new  BranchDTO();
		bean.setId(id);
		bean.setStreet(street);
		bean.setCity(city);
		bean.setState(state);
		bean.setCountry(country);
		bean.setContact(contact);
		bean.setZipCode(zipCode);
		bean.setCreatedBy(createdBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedBy(modifiedBy);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		BranchDTO bean = (BranchDTO)bDto;
		id = bean.getId();
		street = bean.getStreet();
		city = bean.getCity();
		country = bean.getCountry();
		state = bean.getState();
		contact = bean.getContact();
		zipCode = bean.getZipCode();
		createdBy = bean.getCreatedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedBy = bean.getModifiedBy();
		modifiedDateTime = bean.getModifiedDatetime();
		
	}

}
