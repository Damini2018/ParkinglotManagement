package com.dreamCompany.services.exitservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.services.ParkingLotManager;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;

public abstract class IExitGate {
    ParkingSpotManager parkingSpotManager;
   abstract Ticket letGoVehicle(Vehicle vehicle);
    abstract Ticket letGoVehicle(Ticket ticket);

}
