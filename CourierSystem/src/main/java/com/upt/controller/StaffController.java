package com.upt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.upt.service.BranchServiceInt;
import com.upt.service.UserServiceInt;
import com.upt.util.DataUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upt.dto.BranchDTO;
import com.upt.dto.BranchStaffDTO;
import com.upt.dto.UserDTO;
import com.upt.exception.DuplicateRecordException;
import com.upt.form.UserRegistrationForm;
import com.upt.service.BranchSatffServiceInt;

@Controller
public class StaffController extends BaseCtl {
	
	private Logger log = Logger.getLogger(StaffController.class.getName());

	@Autowired
	private BranchSatffServiceInt service;
	
	@Autowired
	private UserServiceInt userServiceInt;
	
	@Autowired
	private BranchServiceInt branchServiceInt;
	
	@ModelAttribute
	public void preload(Model model) {
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Male", "Male");
		map2.put("Female", "Female");
		map2.put("Others", "Others");
		model.addAttribute("gender", map2);
		
		List<BranchDTO> searchList = branchServiceInt.search(null);
		model.addAttribute("searchList", searchList);
	}
	
	@GetMapping("/home/login/staff")
	public String display(@RequestParam(required = false) Long id,@ModelAttribute("form") UserRegistrationForm form, Model model, HttpSession session) {
		log.info("StaffController display method start");
			if(form.getId() > 0 ) {
				UserDTO dto = userServiceInt.findBypk(id);
				form.populate(dto);
				BranchStaffDTO user = service.findByUserId(id);
				if(user!=null) {
					BranchDTO branch = user.getBranch();
					model.addAttribute("branch", branch.getFullBranchName());
					model.addAttribute("bId", branch.getId());
					model.addAttribute("staffId", id);
				}
				
				
			}
			
			log.info("StaffController display method End");
		return "addStaff";
	}
	
	@PostMapping("/home/login/staff")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") UserRegistrationForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request) {

		log.info("StaffController submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/register";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "addStaff";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				UserDTO entity = (UserDTO) populateDTO(form.getDTO(), request);
				long id = DataUtility.getLong(request.getParameter("id"));
				if(entity.getId() > 0) {
					entity.setRoleId(3L);
					entity.setRoleName("STAFF");
					BranchStaffDTO branchStaffDTO = new BranchStaffDTO();
					userServiceInt.update(entity);
					branchStaffDTO.setUserId(id);
					branchStaffDTO.setUser(userServiceInt.findBypk(id));
					branchStaffDTO.setBranchId(DataUtility.getLong(request.getParameter("bId")));
					branchStaffDTO.setBranch(branchServiceInt.findBypk(DataUtility.getLong(request.getParameter("bId"))));
					service.add(branchStaffDTO);
					model.addAttribute("success", "Staff Updated Successfully!!!!");
					return "addStaff";
				}else {
				entity.setRoleId(3L);
				entity.setRoleName("STAFF");
				BranchStaffDTO branchStaffDTO = new BranchStaffDTO();
				long pk = userServiceInt.add(entity);
				branchStaffDTO.setUserId(pk);
				branchStaffDTO.setUser(userServiceInt.findBypk(pk));
				branchStaffDTO.setBranchId(DataUtility.getLong(request.getParameter("bId")));
				branchStaffDTO.setBranch(branchServiceInt.findBypk(DataUtility.getLong(request.getParameter("bId"))));
				service.add(branchStaffDTO);
				model.addAttribute("success", "Staff Added Successfully!!!!");
				return "addStaff";
				}
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "addStaff";
		}

		log.info("StaffController submit method end");
		return "addStaff";
	}
	
	@RequestMapping(value = "/home/login/staff/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") UserRegistrationForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/staff/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} else if (OP_NEW.equals(operation)) {
			return "redirect:/home/user";
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 8 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					UserDTO dto = new UserDTO();
					dto.setId(id);
					userServiceInt.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		
		UserDTO dto = (UserDTO) form.getDTO();
		
		UserDTO uDto = (UserDTO) session.getAttribute("user");
		
		List<UserDTO> list = userServiceInt.search(dto, pageNo, pageSize);
		List<UserDTO> totallist = userServiceInt.search(dto);
		
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "staffList";
	}
	
	
	
}
