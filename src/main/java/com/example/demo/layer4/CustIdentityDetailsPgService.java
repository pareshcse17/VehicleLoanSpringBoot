package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.CustIdentityDetailsPg;
import com.example.demo.layer3.exceptions.IdentityNotFoundException;

public interface CustIdentityDetailsPgService {

	List<CustIdentityDetailsPg> getAllIdentityService() throws IdentityNotFoundException;
	List<CustIdentityDetailsPg> getIdentityByCustIdService(long custId) throws IdentityNotFoundException;
	CustIdentityDetailsPg insertIdentityService(CustIdentityDetailsPg newIdentity,long custId);
	String deleteIdentityService(long id) throws IdentityNotFoundException;
}
