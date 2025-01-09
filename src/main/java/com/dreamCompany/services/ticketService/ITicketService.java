package com.dreamCompany.services.ticketService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

public interface ITicketService {
     Ticket createTicket(Vehicle vehicle);
     Ticket createTicket(ParkingSpot parkingSpot);

     Ticket markTicketForExit(Ticket ticket);
     void saveTicket(Ticket ticket);
     Ticket findTicketByVehicleId(String vin);
}
