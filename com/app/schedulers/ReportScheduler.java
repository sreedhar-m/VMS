package com.app.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportScheduler {
	@Autowired
	private ReportGenerator gen;
	
	
//	@Scheduled(fixedDelay=15000)
//	public void scheduleReports(){
//		gen.generateReport();
//		
//	}
}
