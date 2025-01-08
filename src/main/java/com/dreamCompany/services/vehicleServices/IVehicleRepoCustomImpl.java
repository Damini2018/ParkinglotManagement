package com.dreamCompany.services.vehicleServices;

import com.dreamCompany.Models.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class IVehicleRepoCustomImpl implements IVehicleRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        mongoTemplate.save(vehicle);
    }
}
