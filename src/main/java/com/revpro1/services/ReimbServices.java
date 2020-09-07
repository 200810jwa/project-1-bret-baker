package com.revpro1.services;

import java.util.List;

import com.revpro1.dao.ReimbursementDAO;
import com.revpro1.dao.UserDAO;
import com.revpro1.models.Reimbursement;
import com.revpro1.models.User;
import com.revpro1.models.templates.InsertReimbTemplate;

public class ReimbServices {

	private ReimbursementDAO reimbDAO = new ReimbursementDAO();
	private UserDAO userDAO = new UserDAO();

	public List<Reimbursement> getAll() {

		List<Reimbursement> reimbs = reimbDAO.getAllReimbursements();

		if (reimbs == null) {
//			throw exception
			return null;
		}

		return reimbs;

	}

	public List<Reimbursement> getById(int id) {

		List<Reimbursement> reimbs = reimbDAO.getById(id);

		if (reimbs == null) {
//			throw exception
			return null;
		}

		return reimbs;

	}
	
	public boolean approveById(int id, int resolverId) {

		boolean approve = reimbDAO.approveById(id, resolverId);

		if (approve == false) {
//			throw exception
			return approve;
		}

		return approve;

	}
	
	public boolean denyById(int id, int resolverId) {

		boolean deny = reimbDAO.denyById(id, resolverId);

		if (deny == false) {
//			throw exception
			return deny;
		}

		return deny;

	}
	
	public List<Reimbursement> getByAuthor(String author) {

		List<User> users = userDAO.getByUsername(author);
		int authorId = users.get(0).getId();
		List<Reimbursement> reimbs = reimbDAO.getByAuthorId(authorId);

		if (reimbs == null) {
//			throw exception
			return null;
		}

		return reimbs;

	}
	
	public boolean addReimb(InsertReimbTemplate insertReimbTemplate) {
		
		boolean insert = reimbDAO.insert(insertReimbTemplate);
		
		if (insert) {
			return insert;
		} else {
//			throw exception
			return insert;
		}
		
		
	}
	
	public List<Reimbursement> getByStatus(int statusId) {
		
		List<Reimbursement> reimbs = reimbDAO.getByStatusId(statusId);

		if (reimbs == null) {
//			throw exception
			return null;
		}

		return reimbs;

	}

}
