package com.dreamCompany.services.vehicleServices;

import com.dreamCompany.Models.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {
    private final IVehicleRepo vehicleRepo;

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicleRepo.saveVehicle(vehicle);
    }

    @Override
    public Vehicle findById(String vin) {
        return vehicleRepo.findById(vin).orElse(null);
    }

}
