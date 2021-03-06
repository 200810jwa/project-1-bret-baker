package com.revpro1.web;

import java.io.BufferedReader;
import java.io.IOException;
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
import com.revpro1.services.LoginService;

public class LoginServlet extends HttpServlet {
	
	public static Log4J log = new Log4J(); 

//	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();
	private LoginService loginService = new LoginService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		
		String body = reader.lines().collect(Collectors.joining());
		
		LoginTemplate loginTemplate = objectMapper.readValue(body, LoginTemplate.class);
		
		User user = loginService.login(loginTemplate);
		
		if(user == null) {
//			throw exception
			log.loginF();
			response.setStatus(400);
		} else {
			HttpSession session = request.getSession();
			// This creates a cookie with a single key-value
			// JSESSIONID = something
			// Which represents our session
			
			// Store this employee object on the backend/server corresponding to this session
			session.setAttribute("currentUser", user);
			log.loginS();
			ResponseUtil.writeJSON(response, user);
//			System.out.println(user.toString());
			
		}
	}

}
