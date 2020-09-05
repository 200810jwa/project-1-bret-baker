package com.revpro1.services;

import java.util.List;

import com.revpro1.dao.ReimbursementDAO;
import com.revpro1.models.Reimbursement;

public class ReimbServices {
	
	private ReimbursementDAO reimbDAO = new ReimbursementDAO();
	
	public List<Reimbursement> getAll() {
		
		List<Reimbursement> reimbs = reimbDAO.getAllReimbursements();
		
		if (reimbs == null) {
//			throw exception
			return null;
		}
		
		return reimbs;
		
	}

}
