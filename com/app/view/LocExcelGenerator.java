package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocExcelGenerator extends AbstractExcelView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		res.setHeader("Content-Disposition", "attachment; filename=\"LocationData.xls\"");

		@SuppressWarnings("unchecked")
		List<Location> list=(List<Location>) model.get("locList");

		Sheet sheet = book.createSheet("Vendor data Excel");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Location Name");
		header.createCell(1).setCellValue("Location Type");

		int rowCount = 1;
		for (Location l : list){
			Row LocationRow = sheet.createRow(rowCount++);
			LocationRow.createCell(0).setCellValue(l.getLocName());
			LocationRow.createCell(1).setCellValue(l.getLocType());
		}
	}
}
