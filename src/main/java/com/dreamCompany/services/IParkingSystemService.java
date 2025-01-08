package com.dreamCompany.services;


import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

import java.util.List;

public interface IParkingSystemService {
    void bookParkingSpotForVehicle(VehicleContext vehicleContext);

    void freeParkingSpotForVehicle(VehicleContext vehicleContext);

    <T extends ParkingSpot> List<T> findAllAvailableParkingSpots();
    long getAvailableParkingSpaces(VehicleType vehicleType);
    long getTotalParkingSpaces(VehicleType vehicleType);

    ParkingSpot findAvailableParkingSpot(VehicleType vehicleType);
}
