package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.CustIdentityDetailsPg;
import com.example.demo.layer3.CustIdentityDetailsPgRepoIMPL;
import com.example.demo.layer3.exceptions.IdentityNotFoundException;

@Service
public class CustIdentityDetailsPgServiceIMPL implements CustIdentityDetailsPgService {

	@Autowired
	CustIdentityDetailsPgRepoIMPL identityRepo;
	
	@Override
	public List<CustIdentityDetailsPg> getAllIdentityService() throws IdentityNotFoundException {
		// TODO Auto-generated method stub
		return identityRepo.getAllIdentity();
	}

	@Override
	public List<CustIdentityDetailsPg> getIdentityByCustIdService(long custId) throws IdentityNotFoundException {
		// TODO Auto-generated method stub
		return identityRepo.getIdentityByCustId(custId);
	}

	@Override
	public CustIdentityDetailsPg insertIdentityService(CustIdentityDetailsPg newIdentity, long custId) {
		// TODO Auto-generated method stub
		return identityRepo.insertIdentity(newIdentity, custId);
	}

	@Override
	public String deleteIdentityService(long id) throws IdentityNotFoundException {
		// TODO Auto-generated method stub
		return identityRepo.deleteIdentity(id);
	}

}
