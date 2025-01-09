package com.dreamCompany.services.entryservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

public interface IEntryGateService {


    Ticket issueTicket(Vehicle vehicle);

    long getTotalAvailableSpot(VehicleType vehicleType);

    long getTotalParkingSpot(VehicleType vehicleType);

    ParkingSpot findAvailableParkingSpot(VehicleType vehicleType);
}
