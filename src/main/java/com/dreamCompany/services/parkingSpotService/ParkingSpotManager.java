package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.Models.parkingspotModel.TwoWheelerParkingSpot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ParkingSpotManager {
    private final ParkingSpotFactory parkingSpotFactory;

    public void addSpot(ParkingSpot parkingSpot) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(parkingSpot.getVehicleType());
        parkingSpotStratedgy.addParkingSpot(parkingSpot);
    }

    public void addSpotsList(VehicleType vehicleType, int numbers) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(vehicleType);
        List<ParkingSpot> newSpots = new ArrayList<>();
        for (int i = 0; i < numbers; i++) {
            TwoWheelerParkingSpot spot = new TwoWheelerParkingSpot();
            spot.setId("F-" + i);
            spot.setAvailable(true);
            spot.setVehicleType(vehicleType);
            newSpots.add(spot);
        }
        parkingSpotStratedgy.addParkingSpotList(newSpots);
    }

    public void removeSpot(ParkingSpot parkingSpot) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(parkingSpot.getVehicleType());
        parkingSpotStratedgy.removeParkingSpot(parkingSpot);
    }

    public void markSpotUnavailable(ParkingSpot parkingSpot) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(parkingSpot.getVehicleType());
        parkingSpotStratedgy.markSpotUnavailable(parkingSpot);
    }

    public void markSpotAvailable(ParkingSpot parkingSpot) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(parkingSpot.getVehicleType());
        parkingSpotStratedgy.markSpotAvailable(parkingSpot);
    }

    public Ticket bookSpotForVehicle(Vehicle vehicle) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(vehicle.getVehicleType());
        System.out.println("Before parking spot utilized " + parkingSpotStratedgy.getCountForUtilizedParking());
        Ticket ticket = parkingSpotStratedgy.bookSpotForVehicle(vehicle);
        System.out.println("After parking spot utilized " + parkingSpotStratedgy.getCountForUtilizedParking());
        return ticket;
    }

    public void removeBookedSpot(Vehicle vehicle) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(vehicle.getVehicleType());
        System.out.println("Before parking spot freed " + parkingSpotStratedgy.getCountForUtilizedParking());
        parkingSpotStratedgy.removeBookedSpotByVehicle(vehicle);
        System.out.println("After parking spot freed " + parkingSpotStratedgy.getCountForUtilizedParking());

    }

    public void removeBookedSpot(Ticket ticket) {
        IParkingSpotStratedgy parkingSpotStratedgy = getParkingSpotStratedgy(ticket.getVehicleType());
        parkingSpotStratedgy.removeBookedSpotByVehicle(ticket);
    }

    public IParkingSpotStratedgy getParkingSpotStratedgy(VehicleType vehicleType) {
        return parkingSpotFactory.getParkingSpotBasedOnVehicle(vehicleType);
    }
}
