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
import com.revpro1.models.Reimbursement;
import com.revpro1.models.User;
import com.revpro1.models.templates.LoginTemplate;
import com.revpro1.utils.ResponseUtil;
import com.revpro1.services.HelloService;
import com.revpro1.services.LoginService;
import com.revpro1.services.ReimbServices;

public class ReimbServlet2 extends HttpServlet {
	
	public static Log4J log = new Log4J();

	private ReimbServices reimbServices = new ReimbServices();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String author = request.getParameter("author");
		
		List<Reimbursement> reimbs = reimbServices.getByAuthor(author);
		
		if(reimbs == null) {
//			throw exception
			log.loadReimbsF();
			response.setStatus(400);
		} 
		
		else {
			
//			System.out.println("arraylist of reimbs = " + reimbs.toString());
			log.loadReimbsS();
			ResponseUtil.writeJSON(response, reimbs);
			
		}
	}

}
