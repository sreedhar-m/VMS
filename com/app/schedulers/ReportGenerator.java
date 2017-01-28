package com.app.schedulers;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
   @Autowired
	private LocWorkBookLogic logic;
   
   public void generateReport(){
	   HSSFWorkbook workbook=logic.constuctWorkBook();
	   Date d=new Date();
	   try {
		FileOutputStream fos=new FileOutputStream("F:/raghu sir dwnlds/reports/locFile"+d.getDate()+"-"+d.getTime()+"-"+d.getSeconds()+".xls");
		workbook.write(fos);
		fos.flush();
		fos.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
}
