package com.revpro1.logger;

import org.apache.log4j.Logger;

public class Log4J {
	
	private static Logger log = Logger.getLogger(Log4J.class);
	
	public void loginS() {
		log.info("Login success");
	}
	
	public void loginF() {
		log.error("Login fail");
	}
	
	public void helloS() {
		log.info("Hello success");
	}
	
	public void helloF() {
		log.error("Hello fail");
	}
	
	public void loadReimbsS() {
		log.info("Load reimbursements success");
	}
	
	public void loadReimbsF() {
		log.error("Load reimbursements fail");
	}
	
	public void loadReimbS() {
		log.info("Load reimbursement success");
	}
	
	public void loadReimbF() {
		log.error("Load reimbursement fail");
	}
	
	public void approveReimbS() {
		log.info("Approve reimbursement success");
	}
	
	public void approveReimbF() {
		log.error("Approve reimbursement fail");
	}
	
	public void denyReimbS() {
		log.info("Deny reimbursement success");
	}
	
	public void denyReimbF() {
		log.error("Deny reimbursement fail");
	}
	
	public void addReimbS() {
		log.info("Add reimbursement success");
	}
	
	public void addReimbF() {
		log.error("Add reimbursement fail");
	}
	
	public void logoutS() {
		log.info("Logout success");
	}
	
	public void logoutF() {
		log.error("Logout fail");
	}

}
