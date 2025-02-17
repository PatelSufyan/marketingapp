package com.marketingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.service.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	// http://localhost:8080/viewCreateLead

	@RequestMapping(value = "/viewCreateLead", method = RequestMethod.GET)
	public String viewCreateLeadForm() {
		return "create_registration";
	}

//	 @RequestMapping(value = "/saveLead", method = RequestMethod.POST)
//	 public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "Record is saved!!");
//		return "create_registration";
//	 }

	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
	public String saveOneLead(LeadDto leadDto, ModelMap model) {
		Lead l = new Lead();
		l.setFirstName(leadDto.getFirstName());
		l.setLastName(leadDto.getLastName());
		l.setEmail(leadDto.getEmail());
		l.setMobile(leadDto.getMobile());
		
		leadService.saveLead(l);
		
		model.addAttribute("msg", "Record is saved!!");
		return "create_registration";
	}

}