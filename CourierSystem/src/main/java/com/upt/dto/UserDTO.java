package com.upt.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "c_user")
@Setter
@Getter
public class UserDTO extends BaseDTO {
	
	@Column(name = "login", length = 255)
	private String login;
	@Column(name = "first_name", length = 255)
	private String firstName;
	@Column(name = "last_name", length = 255)
	private String lastName;
	@Column(name = "gender", length = 255)
	private String gender;
	@Column(name = "mobile_no", length = 255)
	private String mobileNo;
	@Column(name = "password", length = 255)
	private String password;
	@Column(name = "role_id", length = 255)
	private Long roleId;
	@Column(name = "role_name", length = 255)
	private String roleName;
	@Column(name = "dob")
	private String dob;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "c_branchstaff", 
	joinColumns = {@JoinColumn(name="user")},inverseJoinColumns = {@JoinColumn(name="branch")})
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<BranchDTO> branches = new ArrayList<>();
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
 	private List<CourierDTO> couriers = new ArrayList<CourierDTO>();
	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return null;
	}
	

}
