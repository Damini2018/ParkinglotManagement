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

    public void initializeParkingLot(){
        System.out.println("Initialization done");
        List<TwoWheelerParkingSpot> twoWheelerParkingSpots = new ArrayList<>();
        List<FourWheelerParkingSpot> fourWheelerParkingSpots = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            TwoWheelerParkingSpot twoSpot = new TwoWheelerParkingSpot();
            twoSpot.setId("T-" + i);
            twoSpot.setAvailable(true);
            twoSpot.setVehicleType(VehicleType.TWO_WHEELER);
            twoWheelerParkingSpots.add(twoSpot);

            FourWheelerParkingSpot fourSpot = new FourWheelerParkingSpot();
            fourSpot.setId("F-" + i);
            fourSpot.setAvailable(true);
            fourSpot.setVehicleType(VehicleType.FOUR_WHEELER);
            fourWheelerParkingSpots.add(fourSpot);
        }

        // Set parking spots using the new method
        IParkingSpotStratedgy twoWheelerStrategy = parkingSpotManager.getParkingSpotStratedgy(VehicleType.TWO_WHEELER);
        IParkingSpotStratedgy fourWheelerStrategy = parkingSpotManager.getParkingSpotStratedgy(VehicleType.FOUR_WHEELER);

        twoWheelerStrategy.setParkingSpotList(twoWheelerParkingSpots);
        fourWheelerStrategy.setParkingSpotList(fourWheelerParkingSpots);

    }

    public void entryVehicle(Vehicle vehicle){
        parkingSpotManager.bookSpotForVehicle(vehicle);
    }

    public void exitVehicle(Vehicle vehicle){
        parkingSpotManager.removeBookedSpot(vehicle);
    }
    public void exitVehicle(Ticket ticket){
        parkingSpotManager.removeBookedSpot(ticket);
    }
}
