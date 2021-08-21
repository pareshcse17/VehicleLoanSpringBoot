package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer2.VehicleModelPg;
import com.example.demo.layer3.AdminDetailRepoIMPL;
import com.example.demo.layer3.CustBasicDetailsPgRepoIMPL;
import com.example.demo.layer3.LoanAmountsPgRepoIMPL;
import com.example.demo.layer3.VehicleModelPgRepoImpl;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;
import com.example.demo.layer3.exceptions.NoAdminFoundException;

@SpringBootTest
class VehicleDemoApplicationTests {


	@Autowired
	AdminDetailRepoIMPL admDetImpl;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testGetAllAdmin() throws NoAdminFoundException {
		List<AdminDetail> allAdmin = admDetImpl.getAllAdmin();
		for(AdminDetail a : allAdmin) {
			System.out.println("Admin ID: " +a.getAdminId());
			System.out.println("Admin User Name: "+a.getAdminUsername());
		}
	}
	
	@Autowired
	CustBasicDetailsPgRepoIMPL custBD;
	@Test
	public void registerCustomer() throws CustomerNotFoundException {

		CustBasicDetailsPg cbd = new CustBasicDetailsPg(25, null, "Jonas@mail.com", "LTI", 0, 0, "Jonas", "M", "Ronaldo", "Qwerty@123", "8444214533", "Indian", "441101", "cDYNRKIotXZK", "Mumbai", "Maharastra", 1000000, "SelfEmployed");
		custBD.registerCustomer(cbd);
        System.out.println("Customer Inserted");
        List<CustBasicDetailsPg> cregs = custBD.selectAllCustomer();
        for(CustBasicDetailsPg creg : cregs) {
        System.out.println("Age :"+ creg.getAge());
    	System.out.println("dob  :"+ creg.getDob());
    	System.out.println("EmailID :"+ creg.getEmailId());
    	System.out.println("EmployerName :"+ creg.getEmployerName());
    	System.out.println("ExistingEmiAmount :"+ creg.getExistingEmisAmount());
    	System.out.println("ExistingEmiCount :"+ creg.getExistingEmisCount());
    	System.out.println("FirstName :"+ creg.getFirstName());
    	System.out.println("Gender :"+ creg.getGender());
    	System.out.println("LastName :"+ creg.getLastName());
    	System.out.println("LoginPassword :"+ creg.getLoginPassword());
    	System.out.println("Mobile :"+ creg.getMobile());
    	System.out.println("Nationality :"+ creg.getNationality());
    	System.out.println("Pincode :"+ creg.getPinCode());
    	System.out.println("ResidenceAddress :"+ creg.getResidenceAddress());
    	System.out.println("RecidenceCity :"+ creg.getResidenceCity());
    	System.out.println("ResidenceState :"+ creg.getResidenceState());
    	System.out.println("SalaryPA :"+ creg.getSalaryPa());
    	System.out.println("TypeOfEmployement :"+ creg.getTypeOfEmployment());
        }

       }
	
	@Autowired
	VehicleModelPgRepoImpl vmodr;
	@Test
	void testselectAllModels() {
		List<VehicleModelPg> allModels = vmodr.selectAllModels();
		for(VehicleModelPg a : allModels) {
			System.out.println("Model ID: " +a.getModelId());
			System.out.println("Vehicle Type: "+a.getVehicleType());
			System.out.println("Company Name: "+a.getVehicleCompanyName());
			System.out.println("Model Name: "+a.getModelName());
			System.out.println("ExShowroom Price: "+a.getExShowroomPrice());	
		}
	}
	@Test
	public void insertVehicleCompany(){

		VehicleModelPg cbd = new VehicleModelPg(null, 75000, "Activa", 85000,"Honda","2 Wheeler");
		vmodr.insertVehicleCompany(cbd);;
        System.out.println("Vehicle Inserted");
        List<VehicleModelPg> cregs = vmodr.selectAllModels();
        for(VehicleModelPg creg : cregs) {
        System.out.println("Vehicle Type :"+ creg.getVehicleType());
    	System.out.println("Vehicle Company Name  :"+ creg.getVehicleCompanyName());
    	System.out.println("Vehicle Model Name :"+ creg.getModelName());
    	System.out.println("exShowroom Price :"+ creg.getExShowroomPrice());
    	System.out.println("On Road Price :"+ creg.getOnRoadPrice());
    	System.out.println("Description :"+ creg.getDepcription());
        }
	}
	@Autowired
	LoanAmountsPgRepoIMPL loan;
	@Test
	void testselectAllLoanAmounts() {
		List<LoanAmountsPg> allLoanpays = loan.selectAllLoanAmounts();
		for(LoanAmountsPg a : allLoanpays) {
			System.out.println("LoanPayment ID:"+a.getLoanTypeId());
			System.out.println("Processing Fee:"+a.getProcessingFee());
			System.out.println("Max Range:"+a.getMaxPriceRange());
			System.out.println("Min Range:"+a.getMinPriceRange());
		}
	}

}
