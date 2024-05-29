package com.upt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "c_courier")
@Setter
@Getter
public class CourierDTO extends BaseDTO {
	@Column(name = "sender_name", length = 255)
	private String senderName;
	@Column(name = "receiver_name", length = 255)
	private String receiverName;
	@Column(name = "sender_address", length = 255)
	private String senderAddress;
	@Column(name = "receiver_address", length = 255)
	private String receiverAddress;
	@Column(name = "sender_number", length = 255)
	private String senderNo;
	@Column(name = "receiver_number", length = 255)
	private String receiverNo;
	@Column(name = "branch_id", length = 255)
	private Long branchId;
	
	@ManyToOne
	@JoinColumn(name = "branch")
	private BranchDTO branch;
	
	@ManyToOne
	@JoinColumn(name = "staff")
	private UserDTO staff;
	
	@Column(name = "tracking_number", length = 255)
	private Long trackingNo;
	@Column(name = "status", length = 255)
	private String status;
	@Column(name = "weight", length = 255)
	private String weight;
	@Column(name = "total_cost", length = 255)
	private String totalCost;
	@Column(name = "staff_id", length = 255)
	private Long staffId;

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return null;
	}

}
