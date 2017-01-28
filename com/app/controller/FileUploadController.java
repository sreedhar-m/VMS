package com.app.controller;

import java.io.IOException;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.IFileUploadDao;
import com.app.model.FileUpload;
import com.app.service.IFileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	private IFileUploadService service;
	@Autowired
	private IFileUploadDao dao;

	//show upload page
	@RequestMapping(value="/fileUpload")
	public String showUpload(ModelMap map){
		map.addAttribute("fileList",service.getFilesDetails());
		return "FileUpload";
	}

	//save uploaded file
	@RequestMapping(value="/saveFile",method=RequestMethod.POST)
	public String saveUploadedFile(@RequestParam("uFile")MultipartFile file){
		if(file.getSize()!=0){
			FileUpload up=new FileUpload();
			up.setFileName(file.getOriginalFilename());
			try {
				up.setFileData(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			service.saveFile(up);
		}
		return "redirect:fileUpload";
	}

	@RequestMapping("/download")
	public void downloadFile(@RequestParam("id")int id,HttpServletResponse res){
		FileUpload file=dao.getFileById(id);
		//		String mime=URLConnection.guessContentTypeFromName(file.getFileName());
		//		System.out.println(mime);

		res.addHeader("Content-Disposition", "attachment; filename="+file.getFileName());

		try {
			FileCopyUtils.copy(file.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
