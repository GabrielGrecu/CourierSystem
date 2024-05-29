package com.upt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.upt.dto.BranchDTO;
import com.upt.dto.CourierDTO;
import com.upt.dto.UserDTO;
import com.upt.exception.RecordNotFoundException;
import com.upt.form.CourierForm;
import com.upt.service.BranchServiceInt;
import com.upt.service.CostServiceInt;
import com.upt.service.CourierServiceInt;
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

@Controller
public class CourierController extends BaseCtl {

	@Autowired
	private CourierServiceInt courierService;
	
	@Autowired
	private BranchServiceInt branchServiceInt;
	
	@Autowired
	private CostServiceInt costServiceInt;
	
	@Autowired
	private UserServiceInt userServiceInt;
	
	@ModelAttribute
	public void preload(Model model) {
		
		List<BranchDTO> searchList = branchServiceInt.search(null);
		model.addAttribute("searchList", searchList);
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Added Courier", "Added Courier");
		map2.put("Ready to pick up", "Ready to pick up");
		map2.put("Item Accepted", "Item Accepted");
		map2.put("Item Rejected", "Item Rejected");
		map2.put("Out for Delivery", "Out for Delivery");
		map2.put("Delivered", "Delivered");
		model.addAttribute("cstatus", map2);
	}

	@GetMapping("/home/login/courier")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") CourierForm form,
			HttpSession session, HttpServletResponse response, Model model) throws ServletException, IOException, RecordNotFoundException {
		if (form.getId() > 0) {
			CourierDTO bean = courierService.findBypk(id);
			form.populate(bean);
		}
		UserDTO dto = new UserDTO();
		dto.setRoleId(3L);
		List<UserDTO> staffList = userServiceInt.search(dto);
		model.addAttribute("staffList", staffList);
		return "courier";
	}
	
	@GetMapping("/home/login/view-courier")
	public String viewCourier(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") CourierForm form,
			HttpSession session, HttpServletResponse response, Model model) throws ServletException, IOException, RecordNotFoundException {
		if (form.getId() > 0) {
			CourierDTO bean = courierService.findBypk(id);
			form.populate(bean);
		}
		UserDTO dto = new UserDTO();
		dto.setRoleId(3L);
		List<UserDTO> staffList = userServiceInt.search(dto);
		model.addAttribute("staffList", staffList);
		return "view-courier";
	}

	@PostMapping("/home/login/courier")
	public String submit(@Valid @ModelAttribute("form") CourierForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/courier";
		}
		
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			long pk = 0;
			if (bindingResult.hasErrors()) {
				return "courier";
			}
			CourierDTO bean = (CourierDTO) populateDTO(form.getDTO(),request);
			UserDTO user = (UserDTO)session.getAttribute("user");
			Long roleId = user.getRoleId();
			if (bean.getId() > 0) {
				if(roleId == 3) {
					bean.setStaff(userServiceInt.findBypk(bean.getStaffId()));
					courierService.update(bean);
					model.addAttribute("success", "Status is successfully updated!!!!");
					return "courier";
				}
				bean.setStatus("Pick Up");
				System.out.println("Staff >>"+bean.getStaffId());
				bean.setStaffId(bean.getStaffId());
				bean.setStaff(userServiceInt.findBypk(bean.getStaffId()));
				courierService.update(bean);
				model.addAttribute("success", "Staff Assigned Successfully!!!!");
				return "courier";
			} else {
				bean.setStatus("Added Courier");
				Long trackingNumber = courierService.generateTrackingNumber();
				Long calculatePrice = costServiceInt.calculatePrice(DataUtility.getLong(bean.getWeight()));
				bean.setTotalCost(String.valueOf(calculatePrice));
				bean.setBranch(branchServiceInt.findBypk(bean.getBranchId()));
				bean.setTrackingNo(trackingNumber);
				pk = courierService.add(bean);
				model.addAttribute("id", pk);
				model.addAttribute("success", "Courier Added Successfully!!!!");
			}
			return "redirect:/home/login/payment";
		}
		return "";
	}

	@RequestMapping(value = "/home/login/courier/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") CourierForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/courier/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					CourierDTO dto = new CourierDTO();
					dto.setId(id);
					courierService.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		CourierDTO dto = (CourierDTO) form.getDTO();
		
		List<CourierDTO> list = courierService.search(dto, pageNo, pageSize);
		List<CourierDTO> totallist = courierService.search(dto);
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
		return "courierList";
	}
	
	@GetMapping("/home/login/payment")
	public String payment(@RequestParam(required = false) Long id,@RequestParam(required = false) String success, @ModelAttribute("form") CourierForm form,
			HttpServletResponse response, Model model, HttpServletRequest request) throws ServletException, IOException, RecordNotFoundException {
		if(id!=null) {
			CourierDTO data = courierService.findBypk(id);
			model.addAttribute("totalCost", data.getTotalCost());
		}
		return "payment";
	}
	
	@PostMapping("/home/login/payment")
	public String doPayment(@RequestParam(required = false) Long id,@RequestParam(required = false) String success, @ModelAttribute("form") CourierForm form,
			HttpServletResponse response, Model model, HttpServletRequest request) throws ServletException, IOException, RecordNotFoundException {
		if(OP_PAY.equalsIgnoreCase(form.getOperation())) {
			model.addAttribute("success", "Payment Done Successfully! Tracking No: "+courierService.findBypk(id).getTrackingNo());
		}
		return "payment";
	}
}
