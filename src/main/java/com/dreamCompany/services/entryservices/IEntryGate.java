package com.dreamCompany.services.entryservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;

public abstract class IEntryGate {
    ParkingSpotManager parkingpotManager;

    abstract Ticket issueTicket(Vehicle vehicle);
}
