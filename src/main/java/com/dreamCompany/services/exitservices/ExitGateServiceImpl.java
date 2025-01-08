package com.dreamCompany.services.exitservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.VehicleAction;
import com.dreamCompany.services.VehicleContextService;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExitGateServiceImpl implements IExitGateService {
    private final ParkingSpotManager parkingSpotManager;
    private final VehicleContextService vehicleContextService;
    @Override
    public Ticket letGoVehicle(Vehicle vehicle) {
        VehicleContext vehicleContext =vehicleContextService.getVehicleEntryContext(vehicle);

        //parkingspotManager.bookSpotForVehicle(vehicleContext);
        vehicleContextService.saveContext(vehicleContext);
        System.out.println("ParkingSpot booked for vehicle " + vehicle.toString() + " is " + vehicleContext.getTicket().toString());
        return vehicleContext.getTicket();
    }

    @Override
    public Ticket letGoVehicle(Ticket ticket) {
       // parkingSpotManager.removeBookedSpot(ticket);
        return null;
    }
}
