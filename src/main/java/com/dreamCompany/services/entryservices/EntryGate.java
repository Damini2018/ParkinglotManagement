package com.dreamCompany.services.entryservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class EntryGate extends IEntryGate {

    @Override
    public Ticket issueTicket(Vehicle vehicle) {
        Ticket ticket = parkingpotManager.bookSpotForVehicle(vehicle);
        System.out.println("ParkingSpot booked for vehicle " + vehicle.toString() + " is " + ticket.toString());
        return ticket;
    }
}
