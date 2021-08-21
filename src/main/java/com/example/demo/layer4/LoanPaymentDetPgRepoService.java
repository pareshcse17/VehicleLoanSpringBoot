package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer2.LoanPaymentDetPg;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;
import com.example.demo.layer3.exceptions.LoanPaymentNotFoundException;

public interface LoanPaymentDetPgRepoService {

	void newLoanService(long appId, long adminId);
	void updateAfterEmiService(long loanId, long EmiId);
	List<LoanPaymentDetPg> getAllLoanPaymentsService() throws LoanPaymentNotFoundException;
	List<LoanPaymentDetPg> getLoanPaymentByMobileService(String mobile) throws LoanPaymentNotFoundException;
	List<LoanPaymentDetPg> getLoanPaymentByEmailService(String email) throws LoanPaymentNotFoundException;
	LoanPaymentDetPg getLoanPaymentByApplicationIdService(long appId) throws LoanPaymentNotFoundException;
	List<LoanPaymentDetPg> getLoanPaymentByCustIdService(long custId) throws LoanPaymentNotFoundException;

}
