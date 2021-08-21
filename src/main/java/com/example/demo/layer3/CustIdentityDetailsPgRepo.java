package com.example.demo.layer3;

import java.util.List;

import com.example.demo.layer2.CustIdentityDetailsPg;
import com.example.demo.layer3.exceptions.IdentityNotFoundException;

public interface CustIdentityDetailsPgRepo {

	List<CustIdentityDetailsPg> getAllIdentity() throws IdentityNotFoundException;
	List<CustIdentityDetailsPg> getIdentityByCustId(long custId) throws IdentityNotFoundException;
	CustIdentityDetailsPg insertIdentity(CustIdentityDetailsPg newIdentity,long custId);
	String deleteIdentity(long id) throws IdentityNotFoundException;
}
