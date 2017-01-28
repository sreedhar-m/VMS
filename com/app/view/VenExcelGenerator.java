package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;

public class VenExcelGenerator extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"Vendordata.xls\"");
		
		@SuppressWarnings("unchecked")
		List<Vendor> list=(List<Vendor>) model.get("venList");
		
		Sheet sheet = book.createSheet("Vendor data Excel");
		
		Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("venName");
        header.createCell(1).setCellValue("venEmail");
        header.createCell(2).setCellValue("venLocation");
        
        int rowCount = 1;
        for (Vendor v : list){
            Row vendorRow = sheet.createRow(rowCount++);
            vendorRow.createCell(0).setCellValue(v.getVenName());
            vendorRow.createCell(1).setCellValue(v.getVenEmail());
            vendorRow.createCell(2).setCellValue(v.getLoc().getLocName());
        }
	}

}
