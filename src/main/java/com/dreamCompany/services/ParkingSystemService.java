package com.dreamCompany.services;

import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import com.dreamCompany.services.paymentservices.PaymentManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingSystemService implements IParkingSystemService {
    private final ParkingSpotManager parkingSpotManager;
    private final PaymentManager paymentManager;


    @Override
    public void bookParkingSpotForVehicle(VehicleContext vehicleContext) {
        vehicleContext.getParkingSpot().setAvailable(false);
        vehicleContext.getParkingSpot().setVehicle(vehicleContext.getVehicle());
        vehicleContext.getTicket().setSpotId(vehicleContext.getParkingSpot().getSpotId());
    }


    @Override
    public void freeParkingSpotForVehicle(VehicleContext vehicleContext) {
        vehicleContext.getParkingSpot().setAvailable(true);
        vehicleContext.getParkingSpot().setVehicle(null);
        paymentManager.deductMoney(vehicleContext);
        vehicleContext.getTicket().setPaymentReferenceId(vehicleContext.getPayment().getReferenceId());
    }

    @Override
    public long getAvailableParkingSpaces(VehicleType vehicleType) {
        return parkingSpotManager.getCountOfAvailableSpot(vehicleType);
    }

    @Override
    public void addExtraParkingSpot(VehicleType vehicleType, int total) {
        parkingSpotManager.addExtraParkingSpot(vehicleType, total);
    }
}
