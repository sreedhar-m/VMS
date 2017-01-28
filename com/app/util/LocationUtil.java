package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationUtil {
	@Autowired
	private ILocationService serv;

	public List<Location> getAllLocations(){
		return serv.getAllLocations();
	}

	public void generatePie(String path,List<Object[]> list){
		String finalpath=path+"/abc.jpg";

		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] o:list){
			dataset.setValue(o[0].toString(),Double.parseDouble(o[1].toString()));

		}
		JFreeChart chart= ChartFactory.createPieChart3D("Location Data chart", dataset,true,true,false);
		try {
			ChartUtilities.saveChartAsJPEG(new File(finalpath), chart, 400, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void generateBar(String path,List<Object[]> list){
		//dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] o:list){
			dataset.setValue(Double.parseDouble(o[1].toString()), o[0].toString(),"loc");

		}
		//jfreechart
		JFreeChart chart=ChartFactory.createBarChart("Location Bar chart","Location","Number", dataset);
		//image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/abc2.jpg"), chart, 200,500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
