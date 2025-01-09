package com.dreamCompany.services.ticketService.repository;

import com.dreamCompany.Models.Ticket;

public interface ITicketRepo {
    Ticket findTicketByVehicleId(String vin);
    void saveTicket(Ticket ticket);
}
