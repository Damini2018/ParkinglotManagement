package com.dreamCompany.services;


import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.VehicleType;

public interface IParkingSystemService {
    void bookParkingSpotForVehicle(VehicleContext vehicleContext);

    void freeParkingSpotForVehicle(VehicleContext vehicleContext);

    long getAvailableParkingSpaces(VehicleType vehicleType);
    void addExtraParkingSpot(VehicleType vehicleType, int total);
}
