package com.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class CommonUtil {

	@Autowired
	private JavaMailSender mailSender;

	private final ExecutorService execService = Executors.newFixedThreadPool(1);

	/*if some part of same logic is required in multiple methods because of diff parameters or any other then 

	(we should not write the same logic in multiple methods,here we can go for overloading also
	but it will again force to write the same logic in multiple methods only because of parameters)

	good programming style is
	-write that common logic in a private generic method and 
	-call it from the methods by changing parameters accordingly and
	-keeping conditions to accept parameters in generic method.*/

	//generic email sending method
	private void sendEmailGeneric(String to,String sub,String body,final MultipartFile file)throws Exception{

		final MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setTo(to);
		helper.setSubject(sub);
		helper.setText(body);
		message.setContent(body, "text/html; charset=utf-8");
		if(file!=null){
			helper.addAttachment(file.getOriginalFilename(), new InputStreamSource(){
				public InputStream getInputStream() throws IOException{
					return file.getInputStream();
				}
			});
		}
		//using a new thread to send email
		execService.submit(new Runnable() {
			public void run() {
				// Send email.
				mailSender.send(message);
			}
		});

	}

	//email sending with file
	public void sendEmail(String to,String sub,String body,MultipartFile file) throws Exception{
		sendEmailGeneric(to,sub,body,file);
	}

	//email sending without file
	public void sendEmail(String to,String sub,String body) throws Exception{
		sendEmailGeneric(to,sub,body,null);
	}


	//	public void sendEmailWithFile(String to,String sub,String body,final MultipartFile file)throws Exception{
	//
	//		MimeMessage message = mailSender.createMimeMessage();
	//		MimeMessageHelper helper=new MimeMessageHelper(message,true);
	//		helper.setTo(to);
	//		helper.setSubject(sub);
	//		helper.setText(body);
	//		helper.addAttachment(file.getOriginalFilename(), new InputStreamSource(){
	//			public InputStream getInputStream() throws IOException{
	//				return file.getInputStream();
	//			}
	//		});
	//		
	//		mailSender.send(message);
	//	}
	//	
	//	public void sendEmailWithOutFile(String to,String sub,String body) throws Exception{
	//
	//		MimeMessage message = mailSender.createMimeMessage();
	//		MimeMessageHelper helper=new MimeMessageHelper(message,true);
	//		helper.setTo(to);
	//		helper.setSubject(sub);
	//		helper.setText(body);
	//		
	//		mailSender.send(message);
	//	}

	//	@Scheduled(fixedDelay=50000)
	//	public void msg(){
	//		System.out.println("hello sreedhar"+new Date());
	//	}
}
