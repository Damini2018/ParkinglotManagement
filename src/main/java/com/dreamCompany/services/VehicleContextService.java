package com.dreamCompany.services;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import com.dreamCompany.services.ticketService.ITicketService;
import com.dreamCompany.services.vehicleServices.IVehicleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleContextService {
    private final ParkingSpotManager parkingspotManager;
    private final ITicketService ticketService;
    private final IVehicleService vehicleService;

    public VehicleContext getVehicleEntryContext(Vehicle vehicle) {
        VehicleContext vehicleContext = new VehicleContext(vehicle.getVehicleType());

        ParkingSpot spot = parkingspotManager.findAvailableParkingSpot(vehicleContext.getVehicleType());
        if (spot == null) {
            log.error("No Spot available");
            return null;
        }
        vehicleContext.setParkingSpot(spot);
        Ticket ticket = ticketService.createTicket(vehicle);
        vehicleContext.setTicket(ticket);
        vehicleContext.setVehicle(vehicle);
        return vehicleContext;
    }

    public VehicleContext getVehicleExitContext(Ticket ticket) {
        VehicleContext vehicleContext = new VehicleContext(ticket.getVehicleType());

        ParkingSpot spot = parkingspotManager.findAvailableParkingSpot(ticket.getVehicleType());
        if (spot == null) {
            log.error("No Spot available to free");
            return null;
        }
        Vehicle vehicle = vehicleService.findById(ticket.getVin());
        if (vehicle == null) {
            log.error("No vehicle available to exit");
            return null;
        }
        vehicleContext.setParkingSpot(spot);
        vehicleContext.setTicket(ticket);
        vehicleContext.setVehicle(vehicle);
        return vehicleContext;
    }

    public void saveContext(VehicleContext vehicleContext) {

        if (vehicleContext.getVehicle() != null) {
            vehicleService.saveVehicle(vehicleContext.getVehicle());
        }
        if (vehicleContext.getTicket() != null) {
            ticketService.saveTicket(vehicleContext.getTicket());
        }
        if (vehicleContext.getParkingSpot() != null) {
           parkingspotManager.saveParkingSpot(vehicleContext.getParkingSpot());
        }
    }
}
