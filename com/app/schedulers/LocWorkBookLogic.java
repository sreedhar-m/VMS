package com.app.schedulers;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocWorkBookLogic {
	@Autowired
	private ILocationService service;

	//construct the excel sheet using poi api "HSSFWorkbook"
	public HSSFWorkbook constuctWorkBook(){
		HSSFWorkbook book=new HSSFWorkbook();
		HSSFSheet sheet=book.createSheet();

		List<Location> locList=service.getAllLocations();
		setHeader(sheet);
		setBody(sheet,locList);
		return book;
	}

	//setting header row of excel sheet
	public void setHeader(HSSFSheet sheet){
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("Location Name");
		row.createCell(1).setCellValue("Location Type");
	}

	//setting body of excel sheet
	private void setBody(HSSFSheet sheet, List<Location> locList) {
		int count=1;
		for(Location l:locList){
			HSSFRow row=sheet.createRow(count++);
			row.createCell(0).setCellValue(l.getLocName());
			row.createCell(1).setCellValue(l.getLocType());
		}
	}
}
