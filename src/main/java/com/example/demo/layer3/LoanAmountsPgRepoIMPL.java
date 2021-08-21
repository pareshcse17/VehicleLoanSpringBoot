package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;

@Repository
public class LoanAmountsPgRepoIMPL extends BaseRepository implements LoanAmountsPgRepo {

	@Transactional
	@Override
	public void insertLoanAmount(LoanAmountsPg newAmount) {
		// TODO Auto-generated method stub
		getEntityManager().persist(newAmount);
		System.out.println("repo loan amount inserted");
	}
	
	@Transactional
	@Override
	public LoanAmountsPg selectByloantypeid(long loanAmountid) throws LoanAmountNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("repo loanById");
		return getEntityManager().find(LoanAmountsPg.class, loanAmountid);
		 
	}

	@Transactional
	@Override
	public List<LoanAmountsPg> selectByloantype(String loanType) throws LoanAmountNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Repo Impl-Select By Loan Type");
		return getEntityManager().createQuery("select la from LoanAmountsPg la where la.loanType =: lt").setParameter("lt",loanType).getResultList();
	}

	@Transactional
	@Override
	public List<LoanAmountsPg> selectByPrice(int price) throws LoanAmountNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Repo Impl-Select By Min Max Price");
		return getEntityManager().createQuery("select e from LoanAmountsPg e where e.minPriceRange < :price and e.maxPriceRange > :price").setParameter("price", price).getResultList();
	}

	@Transactional
	@Override
	public List<LoanAmountsPg> selectByMinimumSalaryReq(int salary) throws LoanAmountNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Repo Impl-Select By Minimum SalaryReq");
		return getEntityManager().createQuery("select e from LoanAmountsPg e where e.minSalReqPa > :salary").setParameter("salary", salary).getResultList();
	}

	@Transactional
	@Override
	public void deleteLoanAmount(long loanAmountId) throws LoanAmountNotFoundException {
		// TODO Auto-generated method stub
		LoanAmountsPg foundloanAmount = getEntityManager().find(LoanAmountsPg.class, loanAmountId); //find it 
		if(foundloanAmount!=null) {
			entityManager.remove(foundloanAmount); 
		}	
		else {
			throw new LoanAmountNotFoundException("LoanAmount Not Found with loanAmountId : "+loanAmountId);
		}
		System.out.println("EntityManager: employee removed.. ");
	}

	@Transactional
	@Override
	public List<LoanAmountsPg> selectAllLoanAmounts() {
		// TODO Auto-generated method stub
		System.out.println("Layer3 : loanAmountPgRepoImpl");
		return getEntityManager().createQuery(" from LoanAmountsPg").getResultList();
	}

}
