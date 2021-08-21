package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.layer2.CustIdentityDetailsPg;
import com.example.demo.layer3.exceptions.IdentityNotFoundException;
import com.example.demo.layer4.CustIdentityDetailsPgServiceIMPL;

@CrossOrigin
@Controller
@RequestMapping("/custIdentity/")
public class CustIdentityJPA {

	@Autowired
	CustIdentityDetailsPgServiceIMPL identityServe;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllIdentity")
	public List<CustIdentityDetailsPg> getAllIdentity() {
		System.out.println("IDENTITY JPA");
		try {
			return identityServe.getAllIdentityService();
		} catch (IdentityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getIdenByCustId/{custId}")
	public List<CustIdentityDetailsPg> getIdentityByCustId(@PathVariable long custId){
		System.out.println("IDENTITY JPA");
		try {
			return identityServe.getIdentityByCustIdService(custId);
		} catch (IdentityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@PostMapping(value = "insertIdentity/{custId}")
	public CustIdentityDetailsPg insertIdentity(@RequestBody CustIdentityDetailsPg identity,@PathVariable long custId) {
		System.out.println("IDENTITY JPA");
		return identityServe.insertIdentityService(identity, custId);
	}
	
	@ResponseBody
	@DeleteMapping(value="delIdentity/{id}")
	public String deleteIdentity(@PathVariable long id) {
		System.out.println("IDENTITY JPA");
		try {
			return identityServe.deleteIdentityService(id);
		} catch (IdentityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deletion unsuccessfull";
	}
}
