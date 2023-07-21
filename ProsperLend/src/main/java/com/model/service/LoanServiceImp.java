package com.model.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.entity.Loans;
import com.model.persistence.LoanDao;




@Service
public class LoanServiceImp implements LoanService{

	@Autowired
	private LoanDao loanDao;
	
	
	@Override
	public Loans getLoanById(int loanId) {
		return loanDao.findById(loanId).orElse(null);
	}
	
	
	
	@Override
	public List<Loans> getAllLoans() {
		return loanDao.findAll();
	}
	
	
	
	
	@Override
	public boolean addLoan(Loans loan) {
		try {
		if(loanDao.addLoan(loan.getLoanID(), 
				 loan.getLoanStatus(), loan.getAmount(),
				loan.getInterest(), loan.getLoanDate())>0)
			return true;
		}
		catch(Exception ex) {
			return false;
		}
		return false;
}

	@Override
	public boolean changeAmountInterest(int loanId, Double newAmount, Double newInterest) {
		
		if(loanDao.updateSalaryAmountById(loanId, newAmount, newInterest)>0)
			return true;
		else
			return false;
	
		
	}
	
	
	
}