package com.upt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "c_branchstaff")
@Setter
@Getter
public class BranchStaffDTO extends BaseDTO {
	@Column(name = "barnch_id", length = 255)
	private Long branchId;
	@Column(name = "user_id", length = 255)
	private Long userId;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private UserDTO user;
	
	@ManyToOne
	@JoinColumn(name = "branch")
	private BranchDTO branch;
	

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
