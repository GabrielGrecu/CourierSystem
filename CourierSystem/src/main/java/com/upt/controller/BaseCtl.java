package com.upt.controller;

import javax.servlet.http.HttpServletRequest;

import com.upt.dto.BaseDTO;
import com.upt.dto.UserDTO;
import com.upt.util.DataUtility;
import com.upt.util.DataValidator;

public class BaseCtl {

	protected static final String OP_SAVE = "Save";
	protected static final String OP_PAY = "Pay";
	protected static final String OP_NEW="New";
	protected static final String OP_DELETE="Delete";
	protected static final String OP_NEXT="Next";
	protected static final String OP_PREVIOUS="Previous";
	protected static final String OP_RESET="Reset";
	
	
	protected BaseDTO populateDTO(BaseDTO dto, HttpServletRequest request) {
		
		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;

		UserDTO userbean = (UserDTO) request.getSession().getAttribute("user");

		if (userbean == null) {
			// If record is created without login
			createdBy = "root";
			modifiedBy = "root";
		} else {

			modifiedBy = userbean.getLogin();

			// If record is created first time
			if ("null".equalsIgnoreCase(createdBy)|| DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}

		}

		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
		} else {
			dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
		}

		dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());
		
		return dto;
	}
	
	
}
