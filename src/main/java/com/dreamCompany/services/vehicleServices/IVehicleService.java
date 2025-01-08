package com.dreamCompany.services.vehicleServices;

import com.dreamCompany.Models.Vehicle;

public interface IVehicleService {
    void saveVehicle(Vehicle vehicle);

    Vehicle findById(String vin);
}
