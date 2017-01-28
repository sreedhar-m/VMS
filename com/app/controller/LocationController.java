package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;



@Controller
public class LocationController {
	@Autowired
	private ILocationService locSer;
	@Autowired
	private LocationValidator validator;
	@Autowired
	private LocationUtil util;
    @Autowired
	private ServletContext context;
    
    //show home
    @RequestMapping("/home")
    public String showHomePage(){
    	
    	return "home";
    }
	//show registration page
	@RequestMapping("/regLoc")
	public String showLocView(ModelMap map){
		return "LocationReg";
	}

	//save location
	@RequestMapping(value="/saveLoc",method=RequestMethod.POST)
	public String saveLoc(@ModelAttribute("location")Location location,ModelMap map){
		List<String> l1=validator.doValidate(location);
		if(l1.isEmpty()){
			int i=locSer.saveLocation(location);
			String msg="Location saved successfully with id:: "+i;
			map.addAttribute("res", msg);
		}else{
			map.addAttribute("res", l1);
		}
		return "LocationReg";
	}

	//show all the locations
	@RequestMapping(value="/getLocs")
	public String getAllLoc(ModelMap map){
		map.addAttribute("LocList", locSer.getAllLocations());
		return "LocList";
	}

	//show all the locations in a PDF
	@RequestMapping("/LocPdf")
	public ModelAndView pdfOutput(){
		return new ModelAndView("LocPdf","locPdf",locSer.getAllLocations());
	}

	//show the vendorList as Excel
	@RequestMapping("/LocExcel")
	public ModelAndView excelOutput(){
		return new ModelAndView("LocExcel","locList",locSer.getAllLocations());
	}

	//delete Location
	@RequestMapping("/deleteLoc")
	public String delete(@RequestParam("id")int id,ModelMap map){
		String msg=validator.deleteValidate(id);
		if(null==msg){
		locSer.deleteLocById(id);
		map.addAttribute("msg","Location Successfully deleted with id: "+id);
		}
		else{
			map.addAttribute("msg",msg);
			
		}
		map.addAttribute("LocList", locSer.getAllLocations());
		return "LocList";
	}

	//Show Update Location
	@RequestMapping("/updateLoc")
	public String updateLocById(@RequestParam("id")int locId,ModelMap map){
		map.addAttribute("loc",locSer.getLocationById(locId));
		return "editLocList";
	}

	//save Updated location
	@RequestMapping("/saveUpdatedLoc")
	public String saveUpdatedLoc(@ModelAttribute("location")Location loc){
		locSer.UpdateLocation(loc);
		return "redirect:getLocs";
	}
	
	//show location data as pie chart
	//show location data as bar chart
	@RequestMapping("/showLocReport")
	public String showLocationReport(){
		String path=context.getRealPath("/");
		util.generatePie(path,locSer.getLocwiseCount());
		util.generateBar(path,locSer.getLocwiseCount());
		return "locReport";
	}
	
}