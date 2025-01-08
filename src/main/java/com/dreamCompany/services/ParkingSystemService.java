package com.dreamCompany.services;

import com.dreamCompany.Models.Payment;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.ChargesType;
import com.dreamCompany.Models.enums.PaymentType;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import com.dreamCompany.services.paymentservices.PaymentManager;
import com.dreamCompany.services.ticketService.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSystemService implements IParkingSystemService {
    private final ParkingSpotManager parkingSpotManager;
    private final ITicketService ticketService;
    private final PaymentManager paymentManager;


    @Override
    public void bookParkingSpotForVehicle(VehicleContext vehicleContext) {
// mark vehicle parked
        //mark spot unavailable
        vehicleContext.getParkingSpot().setAvailable(false);
        vehicleContext.getParkingSpot().setVehicle(vehicleContext.getVehicle());
        vehicleContext.getTicket().setSpotId(vehicleContext.getParkingSpot().getSpotId());
    }


    @Override
    public void freeParkingSpotForVehicle(VehicleContext vehicleContext) {
        vehicleContext.getParkingSpot().setAvailable(true);
        vehicleContext.getParkingSpot().setVehicle(null);
    }

    @Override
    public <T extends ParkingSpot> List<T> findAllAvailableParkingSpots() {
        return List.of();
    }

    @Override
    public long getAvailableParkingSpaces(VehicleType vehicleType) {
        return parkingSpotManager.getCountOfAvailableSpot(vehicleType);
    }

    @Override
    public long getTotalParkingSpaces(VehicleType vehicleType) {
        return parkingSpotManager.getCountOfAvailableSpot(vehicleType);
    }

    @Override
    public ParkingSpot findAvailableParkingSpot(VehicleType vehicleType) {
        return parkingSpotManager.findAvailableParkingSpot(vehicleType);
    }
}
