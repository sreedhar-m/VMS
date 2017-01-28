package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class LocPdfGenerator extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter arg2, HttpServletRequest arg3,
			HttpServletResponse arg4) throws Exception {
		List<Location>list=(List<Location>) model.get("locPdf");
		
		Paragraph p=new Paragraph("All Locations List");
		p.setAlignment("center");
		doc.add(p);
		
		Table t = new Table(3);
		doc.addTitle("Location Data");
		
		for(Location loc:list){
			t.addCell(loc.getLocId()+"");
            t.addCell(loc.getLocName());
            t.addCell(loc.getLocType());
		}
		doc.add(t);
	}
         
}
