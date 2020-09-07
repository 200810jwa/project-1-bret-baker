package com.revpro1.dao;

import java.util.List;

import com.revpro1.models.Reimbursement;
import com.revpro1.models.templates.InsertReimbTemplate;

public interface IReimbursementDAO {
	
	public List<Reimbursement> getAllReimbursements();
	public List<Reimbursement> getById(int id);
	public boolean approveById(int id, int resolverId);
	public boolean denyById(int id, int resolverId);
	public List<Reimbursement> getByAuthorId(int authorId);
	public boolean insert(InsertReimbTemplate insertReimbTemplate);
	public List<Reimbursement> getByStatusId(int statusId);

}
