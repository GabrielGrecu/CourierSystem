package com.upt.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "c_branch")
@Entity
public class BranchDTO extends BaseDTO {
	@Column(name = "street", length = 255)
	private String street;
	@Column(name = "city", length = 255)
	private String city;
	@Column(name = "state", length = 255)
	private String state;
	@Column(name = "zipcode", length = 255)
	private String zipCode;
	@Column(name = "country", length = 255)
	private String country;
	@Column(name = "contact", length = 255)
	private String contact;
	@Transient
	private String fullBranchName;
	
	public String getFullBranchName() {
		return street+",".concat(city) +",".concat(state);
	}
	/*
	 * @OneToMany( mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval =
	 * true )
	 * 
	 * @Cascade({org.hibernate.annotations.CascadeType.DELETE}) private
	 * List<BranchStaffDTO> branchStaffList = new ArrayList<>();
	 */

	 	@ManyToMany(mappedBy = "branches", cascade = { CascadeType.ALL })
	 	@OnDelete(action = OnDeleteAction.CASCADE)
	    List<UserDTO> users = new ArrayList<>();
	 	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
	 	@OnDelete(action = OnDeleteAction.CASCADE)
	 	private List<CourierDTO> couriers = new ArrayList<CourierDTO>();
	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
