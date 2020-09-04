package com.revpro1.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtil {
	
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static void writeJSON(HttpServletResponse resp, Object body) throws IOException {
		PrintWriter writer = resp.getWriter();
		
		writer.println(objectMapper.writeValueAsString(body));
		
		resp.setStatus(200);
		resp.setContentType("application/json");
	}
}
