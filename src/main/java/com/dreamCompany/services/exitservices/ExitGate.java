package com.dreamCompany.services.exitservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class ExitGate extends IExitGate{
//we need the ticket id so that we can calculate the exit time and charges

    @Override
    public Ticket letGoVehicle(Vehicle vehicle) {
        parkingSpotManager.removeBookedSpot(vehicle);
        return null;
    }

    @Override
    public Ticket letGoVehicle(Ticket ticket) {
        parkingSpotManager.removeBookedSpot(ticket);
        return null;
    }
}
