package com.dreamCompany.services.entryservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.VehicleAction;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.services.IParkingSystemService;
import com.dreamCompany.services.VehicleContextService;
import com.dreamCompany.services.parkingSpotService.IParkingSpotManager;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import com.dreamCompany.services.ticketService.ITicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EntryGateService implements IEntryGateService {
private final IParkingSystemService parkingSystemService;
private final VehicleContextService vehicleContextService;

    @Override
    public Ticket issueTicket(Vehicle vehicle) {
        VehicleContext vehicleContext =vehicleContextService.getVehicleEntryContext(vehicle);

        parkingSystemService.bookParkingSpotForVehicle(vehicleContext);
        vehicleContextService.saveContext(vehicleContext);
        System.out.println("ParkingSpot booked for vehicle " + vehicle.toString() + " is " + vehicleContext.getTicket().toString());
        return vehicleContext.getTicket();
    }

    @Override
    public long getTotalAvailableSpot(VehicleType vehicleType) {
        return parkingSystemService.getAvailableParkingSpaces(vehicleType);
    }

    @Override
    public long getTotalParkingSpot(VehicleType vehicleType) {
        return parkingSystemService.getAvailableParkingSpaces(vehicleType);
    }

    @Override
    public ParkingSpot findAvailableParkingSpot(VehicleType vehicleType) {
        // parkingspotManager.get
        return null;
    }
}
