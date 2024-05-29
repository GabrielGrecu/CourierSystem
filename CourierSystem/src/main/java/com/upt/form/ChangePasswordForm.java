package com.upt.form;

import javax.validation.constraints.NotEmpty;

import com.upt.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangePasswordForm extends BaseForm{

	
	@NotEmpty(message = "Old Password is required")
	private String oldPassword;
	
	@NotEmpty(message = "Confirm Password is required")
	private String confirmPassword;
	
	@NotEmpty(message = "New Passeword is required")
	private String newPassword;

	@Override
	public BaseDTO getDTO() {

		return null;
	}

	@Override
	public void populate(BaseDTO bDto) {

	}

	
}
