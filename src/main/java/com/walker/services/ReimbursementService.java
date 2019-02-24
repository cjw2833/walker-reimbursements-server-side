package com.walker.services;

import java.io.IOException;
import java.util.List;

import com.walker.daos.ReimbursementDao;
import com.walker.dto.CreateReimbDTO;
import com.walker.dto.UpdateReimbDTO;
import com.walker.models.Reimbursement;

public class ReimbursementService {
	private ReimbursementDao reimbDao = new ReimbursementDao();
	
	public List<Reimbursement> getReimbursementsByIdStatus(int user_id, int status_id) {
		try {
			return reimbDao.getReimbursementsByIdStatus(user_id, status_id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Reimbursement> getReimbursementsByStatus(int status_id){
		try {
			return reimbDao.getReimbursementsByStatus(status_id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void createReimbursementById(CreateReimbDTO cr){
		try {
			reimbDao.addReimbursementById(cr);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateReimbursementStatus(UpdateReimbDTO ur) {
		try {
			reimbDao.updateReimbursementStatus(ur);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ReimbursementService(ReimbursementDao reimbDao) {
		super();
		this.reimbDao = reimbDao;
	}
	
	public ReimbursementService() {
		super();
	}
}
