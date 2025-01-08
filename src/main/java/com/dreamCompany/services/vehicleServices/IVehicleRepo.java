package com.dreamCompany.services.vehicleServices;

import com.dreamCompany.Models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepo extends MongoRepository<Vehicle,String>, IVehicleRepoCustom {
}
