package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.VehicleModelPg;

@Repository
public interface VehicleModelPgRepo {

	void insertVehicle(VehicleModelPg vehicle);
	void insertVehicleCompany(VehicleModelPg newCompany);
	void insertVehicleModel(VehicleModelPg newModel);
	List<VehicleModelPg> selectAllModels();
//	List<VehicleModelPg> selectAllCompanies();
	VehicleModelPg selectVehicleById(Long id);
	List<VehicleModelPg> selectByVehicleType(String vType);
	List<VehicleModelPg> selectByVehicleCName(String cName);
	List<VehicleModelPg> selectByVehicleMName(String mName);
	void deleteVehicleModel(long modelId);
}
