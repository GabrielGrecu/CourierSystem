package com.upt.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upt.dto.CostDTO;
import com.upt.form.CostForm;
import com.upt.service.CostServiceInt;
@Controller
public class CostController extends BaseCtl {

	private Logger log = Logger.getLogger(CostController.class.getName());

	@Autowired
	private CostServiceInt costService;

	@GetMapping("/home/login/addcost")
	public String display(@ModelAttribute("form") CostForm form, HttpSession session, Model model) {
		log.info("CostController display method start");
		log.info("CostController display method End");
		return "addCost";
	}

	@PostMapping("/home/login/addcost")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") CostForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {

		log.info("CostController add-cost submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/addcost";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "addCost";
		}
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			CostDTO entity = (CostDTO) populateDTO(form.getDTO(), request);
			costService.add(entity);
			model.addAttribute("success", "Cost added successfully");

			return "addCost";
		}

		log.info("CostController add-cost submit method end");
		return "addCost";
	}

	@GetMapping("/home/login/viewcost")
	public String displayCost(@ModelAttribute("form") CostForm form, HttpSession session, Model model) {
		log.info("CostController displayCost method start");
		CostDTO bean = new CostDTO();
		bean = costService.getCosts();
		model.addAttribute("bean", bean);
		log.info("CostController displayCost method End");
		return "costList";
	}
}
