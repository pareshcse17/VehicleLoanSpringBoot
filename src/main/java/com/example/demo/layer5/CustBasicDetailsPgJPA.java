package com.example.demo.layer5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer3.BaseRepository;
import com.example.demo.layer3.CustBasicDetailsPgRepoIMPL;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;
import com.example.demo.layer4.CustBasicDetailsPgServiceIMPL;

@CrossOrigin
@Controller
@RequestMapping("/cust/")
public class CustBasicDetailsPgJPA extends BaseRepository {

	@Autowired
	CustBasicDetailsPgServiceIMPL custService;

	public CustBasicDetailsPgJPA() {
		System.out.println("Customer JPA constructor running...");
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "greet")
	String greetEmployee() {
		return "Hello Customer"; // connect to the DB also via spring JPA
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllCust")
	public List<CustBasicDetailsPg> selectAllCust() {
		System.out.println("Customer JPA selectAllCust() invoked");
		try {
			return custService.selectAllCustomerService();
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getCustById/{custId}")
	public CustBasicDetailsPg selectCustById(@PathVariable Long custId) {
		System.out.println("Customer JPA selectCustById() invoked ");
		try {
			return custService.selectCustomerByIdService(custId);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getCustByMobile/{mobile}")
	public CustBasicDetailsPg selectCustByMobile(@PathVariable String mobile) {
		System.out.println("Customer JPA selectCustByMobile() invoked ");
		try {
			return custService.selectCustomerByMobileService(mobile);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getCustByEmail/{email}")
	public CustBasicDetailsPg selectCustByEmailId(@PathVariable String email) {
		System.out.println("Customer JPA selectCustByEmail() invoked ");
		try {
			return custService.selectCustomerByEmailService(email);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@ResponseBody
	@PostMapping(path="/regisCust")
	public CustBasicDetailsPg resgisterCustomer(@RequestBody CustBasicDetailsPg regisCust) {
	
		System.out.println("Cust jpa");
		return custService.registerCustomerService(regisCust);
	}


	@GetMapping
	@ResponseBody
	@RequestMapping(value = "loginCust")
	public CustBasicDetailsPg loginCustomer(@RequestBody CustBasicDetailsPg verifyCust) {
		System.out.println("CustBasic JPA loginCustomer() invoked");
		try {
			return custService.loginCustomerService(verifyCust);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@PostMapping
	@ResponseBody
	@RequestMapping(value = "addCustObject")
	public String insertCustomerObject(@RequestBody CustBasicDetailsPg custObj) {
		System.out.println("JPA insertCustomerObject() INVOKED");
		custService.insertCustomerObjectService(custObj);
		return ("JPA CUST OBJECT ADDED");
	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value = "addCustAppForm2")
	public String insertCustomerApplicationForm(@RequestBody CustBasicDetailsPg custObj) {
		System.out.println("JPA insertCustomerObject() INVOKED");
		custService.insertCustomerForm2Service(custObj);
		return ("JPA CUST OBJECT ADDED");
	}

}
