package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.CustIdentityDetailsPg;
import com.example.demo.layer3.exceptions.IdentityNotFoundException;

@Repository
public class CustIdentityDetailsPgRepoIMPL extends BaseRepository implements CustIdentityDetailsPgRepo {


	@Transactional
	@Override
	public List<CustIdentityDetailsPg> getAllIdentity() throws IdentityNotFoundException {
		// TODO Auto-generated method stub
		return getEntityManager().createQuery(" from CustIdentityDetailsPg").getResultList();
	}

	@Transactional
	@Override
	public List<CustIdentityDetailsPg> getIdentityByCustId(long custId) throws IdentityNotFoundException {
		// TODO Auto-generated method stub
		CustBasicDetailsPg cust= getEntityManager().find(CustBasicDetailsPg.class, custId);
		return getEntityManager()
				.createQuery("select i from CustIdentityDetailsPg i where i.custBasicDetailsPg =: cust")
				.setParameter("cust", cust).getResultList();
	}

	@Transactional
	@Override
	public CustIdentityDetailsPg insertIdentity(CustIdentityDetailsPg newIdentity, long custId) {
		// TODO Auto-generated method stub
		CustBasicDetailsPg cust=getEntityManager().find(CustBasicDetailsPg.class, custId);
		newIdentity.setCustBasicDetailsPg(cust);
		getEntityManager().persist(newIdentity);
		return newIdentity;
	}

	@Transactional
	@Override
	public String deleteIdentity(long id) throws IdentityNotFoundException {
		// TODO Auto-generated method stub
		CustIdentityDetailsPg identity= getEntityManager().find(CustIdentityDetailsPg.class, id);
		if(identity==null) throw new IdentityNotFoundException("identity not found");
		else getEntityManager().remove(identity);
		return "item deleted";
	}

}
