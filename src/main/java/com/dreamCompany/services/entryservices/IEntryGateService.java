package com.dreamCompany.services.entryservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import com.dreamCompany.services.ticketService.ITicketService;

public interface IEntryGateService {


    Ticket issueTicket(Vehicle vehicle);
    long getTotalAvailableSpot(VehicleType vehicleType);
    long getTotalParkingSpot(VehicleType vehicleType);
    ParkingSpot findAvailableParkingSpot(VehicleType vehicleType);
}
