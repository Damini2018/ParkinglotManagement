package com.dreamCompany.services.exitservices;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.services.IParkingSystemService;
import com.dreamCompany.services.VehicleContextService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExitGateServiceImpl implements IExitGateService {
    private final IParkingSystemService parkingSystemService;

    private final VehicleContextService vehicleContextService;

    @Override
    public Ticket letGoVehicle(Vehicle vehicle, String paymentMode, String chargeBasis) {
        VehicleContext vehicleContext = vehicleContextService.getVehicleExitContext(vehicle,paymentMode,chargeBasis);
        parkingSystemService.freeParkingSpotForVehicle(vehicleContext);
        vehicleContextService.saveContext(vehicleContext);
        System.out.println("ParkingSpot booked for vehicle " + vehicle + " is " + vehicleContext.getTicket().toString());
        return vehicleContext.getTicket();
    }

    @Override
    public Ticket letGoVehicle(Ticket ticket, String paymentMode, String chargeBasis) {
        VehicleContext vehicleContext = vehicleContextService.getVehicleExitContext(ticket,paymentMode,chargeBasis);

        parkingSystemService.freeParkingSpotForVehicle(vehicleContext);
        vehicleContextService.saveContext(vehicleContext);
        return vehicleContext.getTicket();
    }
}
