package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Part;
import com.app.service.IPartService;
import com.app.util.VendorUtil;

@Controller
public class PartController {
    
	@Autowired
	private IPartService service;
	@Autowired
	private VendorUtil vUtil;
	
	//show Part registration view page
	@RequestMapping("/regPart")
	public String showPartReg(ModelMap map){
		map.addAttribute("venList",vUtil.getAllVendors());
		return "PartReg";
	}
	
	//save Part form to database
	@RequestMapping(value="/savePart",method=RequestMethod.POST)
	public String savePart(@ModelAttribute("part")Part part,ModelMap map){
		service.savePart(part);
		map.addAttribute("venList",vUtil.getAllVendors());
		return "PartReg";
	}
	
	//show all the parts from database
	public String showAllParts(){
		return "";
	}
	
	
}
