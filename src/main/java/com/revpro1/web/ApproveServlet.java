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
import com.revpro1.models.Reimbursement;
import com.revpro1.models.User;
import com.revpro1.models.templates.LoginTemplate;
import com.revpro1.utils.ResponseUtil;
import com.revpro1.services.HelloService;
import com.revpro1.services.LoginService;
import com.revpro1.services.ReimbServices;

public class ApproveServlet extends HttpServlet {

	private ReimbServices reimbServices = new ReimbServices();
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("reimb_id");
		
		int id1 = Integer.parseInt(id);
		
//		List<Reimbursement> reimbs = reimbServices.getById(id1);
		boolean approve = reimbServices.approveById(id1);
		
		if(approve == false) {
//			throw exception
			response.setStatus(400);
		} 
		
		else {
			
//			System.out.println("arraylist of reimbs = " + reimbs.toString());

			ResponseUtil.writeJSON(response, approve);
			
		}
	}

}