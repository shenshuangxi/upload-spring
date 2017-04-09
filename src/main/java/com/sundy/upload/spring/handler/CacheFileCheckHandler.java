package com.sundy.upload.spring.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.sundy.upload.spring.contant.ContantConfig;


public class CacheFileCheckHandler implements UploaderHandler {
	
	public String getPath() {
		return ContantConfig.instance.chunkCheckPath;
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
}
