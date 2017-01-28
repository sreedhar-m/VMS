package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VenPdfGenerator extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter arg2, HttpServletRequest arg3,
			HttpServletResponse arg4) throws Exception {
		List<Vendor>list=(List<Vendor>) model.get("venPdf");

		Paragraph p=new Paragraph("All Vendors List");
		p.setAlignment("center");
		doc.add(p);

		PdfPTable t = new PdfPTable(5);
		doc.addTitle("Vendor Data");
		for(Vendor ven:list){
			t.addCell(ven.getVenId()+"");
			t.addCell(ven.getVenName());
			t.addCell(ven.getVenEmail());
			t.addCell(ven.getLoc().getLocName());
			t.addCell(ven.getLoc().getLocType());
		}

		doc.add(t);
	}

}
