package com.dreamCompany.services.ticketService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.services.ticketService.repository.ITicketRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {

    private final ITicketRepo ticketRepo;

    @Override
    public Ticket createTicket(Vehicle vehicle) {
        return Ticket.builder()
                .startTime(System.currentTimeMillis())
                .isPaid(false)
                .vin(vehicle.getVin())
                .vehicleType(vehicle.getVehicleType())
                .build();
    }


    @Override
    public Ticket createTicket(ParkingSpot parkingSpot) {
        return Ticket.builder()
                .startTime(System.currentTimeMillis())
                .isPaid(false)
                .vehicleType(parkingSpot.getVehicleType())
                .build();
    }

    @Override
    public Ticket markTicketForExit(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null.");
        }
        ticket.setEndTime(System.currentTimeMillis());
        // Additional logic for calculating charges can be added here
        return ticket;
    }

    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepo.saveTicket(ticket);
    }

    @Override
    public Ticket findTicketByVehicleId(String vin) {
        return ticketRepo.findTicketByVehicleId(vin);
    }
}
