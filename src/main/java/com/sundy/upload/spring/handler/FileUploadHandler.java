package com.sundy.upload.spring.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.alibaba.fastjson.JSON;
import com.sundy.upload.spring.contant.ContantConfig;
import com.sundy.upload.spring.message.RspMessage;


public class FileUploadHandler implements UploaderHandler {

	public String getPath() {
		return ContantConfig.instance.chunkCheckPath;
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}	
}
