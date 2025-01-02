package com.dreamCompany.services;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.FourWheelerParkingSpot;
import com.dreamCompany.Models.parkingspotModel.TwoWheelerParkingSpot;
import com.dreamCompany.services.parkingSpotService.FourWheelerParkingSpotStratedgy;
import com.dreamCompany.services.parkingSpotService.IParkingSpotStratedgy;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import com.dreamCompany.services.parkingSpotService.TwoWheelerParkingSpotStratedgy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ParkingLotManager {
    private ParkingSpotManager parkingSpotManager;



    public void entryVehicle(Vehicle vehicle){
        parkingSpotManager.bookSpotForVehicle(vehicle);
    }

    public void exitVehicle(Vehicle vehicle){
        parkingSpotManager.removeBookedSpot(vehicle);
    }
    public void exitVehicle(Ticket ticket){
        parkingSpotManager.removeBookedSpot(ticket);
    }
    public void increaseParkingSpot(VehicleType vehicleType, int numbers){
       parkingSpotManager.addSpotsList(vehicleType, numbers);

    }
}
