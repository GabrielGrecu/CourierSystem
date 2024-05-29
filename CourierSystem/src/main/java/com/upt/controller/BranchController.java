package com.upt.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.upt.exception.DuplicateRecordException;
import com.upt.exception.RecordNotFoundException;
import com.upt.form.BranchForm;
import com.upt.service.BranchServiceInt;

@Controller
public class BranchController extends BaseCtl {

private Logger log = Logger.getLogger(BranchController.class.getName());
	
	@Autowired
	private BranchServiceInt service;
	
	@GetMapping("/home/login/branch")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") BranchForm form,
			HttpSession session, HttpServletResponse response, Model model) throws ServletException, IOException, RecordNotFoundException {
		if (form.getId() > 0) {
			BranchDTO bean = service.findBypk(id);
			form.populate(bean);
		}
		return "branch";
	}

	@PostMapping("/home/login/branch")
	public String submit(@Valid @ModelAttribute("form") BranchForm form, BindingResult bindingResult,
			HttpSession session, Model model,HttpServletRequest request) {

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/branch";
		}
		
		try {
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {

				if (bindingResult.hasErrors()) {
					return "branch";
				}
				BranchDTO bean = (BranchDTO) populateDTO(form.getDTO(),request);
				if (bean.getId() > 0) {
					service.update(bean);
					model.addAttribute("success", "Branch update Successfully!!!!");
				} else {
					service.add(bean);
					model.addAttribute("success", "Branch Added Successfully!!!!");
				}
				return "branch";
			}
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", e.getMessage());
			return "branch";
		}
		return "";
	}

	@RequestMapping(value = "/home/login/branch/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") BranchForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) throws SQLIntegrityConstraintViolationException {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/branch/search";
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
					BranchDTO dto = new BranchDTO();
					dto.setId(id);
					service.delete(dto);
					
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		BranchDTO dto = (BranchDTO) form.getDTO();
		
		List<BranchDTO> list = service.search(dto, pageNo, pageSize);
		List<BranchDTO> totallist = service.search(dto);
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
		return "branchList";
	}
	
	
	
	
}
