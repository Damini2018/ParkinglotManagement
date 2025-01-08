package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.services.IParkingSystemService;
import com.dreamCompany.services.ticketService.ITicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingSpotManager {
    private final ParkingSpotFactory parkingSpotFactory;
    private final ITicketService ticketService;


    public  ParkingSpot findAvailableParkingSpot(VehicleType vehicleType) {
        IParkingSpotsService parkingSpotService = parkingSpotFactory.getParkingSpotBasedOnVehicle(vehicleType);
        return parkingSpotService.findAvailableParkingSpot(vehicleType);
    }


    public  ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        IParkingSpotsService parkingSpotService = parkingSpotFactory.getParkingSpotBasedOnVehicle(parkingSpot.getVehicleType());
        return parkingSpotService.saveParkingSpot(parkingSpot);
    }

    public long getCountOfAvailableSpot(VehicleType vehicleType) {
        IParkingSpotsService parkingSpotService = parkingSpotFactory.getParkingSpotBasedOnVehicle(vehicleType);
        return parkingSpotService.getTotalAvailableParking();
    }

    public long getCountOfTotalSpot(VehicleType vehicleType) {
        IParkingSpotsService parkingSpotService = parkingSpotFactory.getParkingSpotBasedOnVehicle(vehicleType);
        return parkingSpotService.getTotalParkingSpace();
    }
}
