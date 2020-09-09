package com.revpro1.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revpro1.logger.Log4J;
import com.revpro1.models.User;
import com.revpro1.models.templates.LoginTemplate;
import com.revpro1.utils.ResponseUtil;
import com.revpro1.services.HelloService;
import com.revpro1.services.LoginService;

public class HelloServlet extends HttpServlet {
	
	public static Log4J log = new Log4J();

	private HelloService helloService = new HelloService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("ers_username");
		
		List<User> user = helloService.hello(username);
		
		if(user == null) {
//			throw exception
			log.helloF();
			response.setStatus(400);
		} 
		
		else {

			log.helloS();
			ResponseUtil.writeJSON(response, user.get(0));
			
		}
	}

}
