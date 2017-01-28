package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;
import com.app.validator.VendorValidator;

@Controller
public class VendorController {
	@Autowired
	private IVendorService venSer;
	@Autowired
	private LocationUtil locUtil;
	@Autowired
	private VendorValidator validator;
	@Autowired
	private CommonUtil commonUtil;

	//show vendor registration
	@RequestMapping("/regVen")
	public String showVenView(ModelMap map){
		map.addAttribute("locList",locUtil.getAllLocations());
		return "VendorReg";
	}

	//save vendor
	@RequestMapping(value="/saveVen",method=RequestMethod.POST)
	public String saveVen(@ModelAttribute("vendor")Vendor vendor,ModelMap map,@RequestParam("fileObj")MultipartFile file){
		List<String> list=validator.doValidate(vendor);
		if(list.isEmpty()){
			int i=venSer.saveVendor(vendor);
			String msg="Vendor saved successfully with id::"+i;
			map.addAttribute("res",msg);
			try {
				commonUtil.sendEmail(vendor.getVenEmail(), "Welcome to VendorManagement Mr./Ms."+vendor.getVenName(), msg, file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			map.addAttribute("res","Registration Failed because of following reasons::");
			map.addAttribute("errorsList", list);
		}
		return "VendorReg";
	}

	//show the list of vendors
	@RequestMapping(value="/getVens")
	public String getAllVen(ModelMap map){
//		StopWatch watch=new StopWatch();
//		watch.start();
		map.addAttribute("VenList", venSer.getAllVendors());
//		watch.stop();
//		System.out.println(watch.prettyPrint());
		return "VenList";
	}

	//show the vendorsList as PDF
	@RequestMapping("/VenPdf")
	public ModelAndView pdfOutput(){
		return new ModelAndView("VenPdf","venPdf",venSer.getAllVendors());
	}

	//show the vendorList as Excel
	@RequestMapping("/VenExcel")
	public ModelAndView excelOutput(){
		return new ModelAndView("VenExcel","venList",venSer.getAllVendors());
	}

	//delete Vendor
	@RequestMapping("/deleteVen")
	public String delete(@RequestParam("id")int id){
		venSer.deleteVenById(id);
		return "redirect:getVens";
	}

	//show update Vendor
	@RequestMapping("updateVenById")
	public String showUpdateVen(@RequestParam("id")int id,ModelMap map){
		map.addAttribute("locList",locUtil.getAllLocations());
		map.addAttribute("VenList",venSer.getVendorById(id));
		return "editVenList";
	}

	//update vendor
	@RequestMapping("updateVen")
	public String updateVen(@ModelAttribute("vendor")Vendor vendor){
		venSer.updateVendor(vendor);
		return "redirect:getVens";
	}

}
