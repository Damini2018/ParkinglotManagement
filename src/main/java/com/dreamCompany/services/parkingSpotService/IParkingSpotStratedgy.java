package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

import java.util.List;

public interface IParkingSpotStratedgy {
    boolean parkVehicle();

    boolean unParkVehicle();

    boolean markAvailibility();

    VehicleType getVehicleType();

    List<? extends ParkingSpot> getParkingSpotList();
    void addParkingSpotList(List<? extends ParkingSpot> parkingSpots);
    //based on the find parking spot technique like find near elevator, find near exit gate, find near entry gate
    void addParkingSpot(ParkingSpot parkingSpot);

    void removeParkingSpot(ParkingSpot parkingSpot);

    void markSpotUnavailable(ParkingSpot parkingSpot);

    void markSpotAvailable(ParkingSpot parkingSpot);

    Ticket bookSpotForVehicle(Vehicle vehicle);

    void removeBookedSpot(ParkingSpot spot);
    void removeBookedSpotByVehicle(Vehicle vehicle);
    void removeBookedSpotByVehicle(Ticket ticket);
    long getCountForUtilizedParking();
}
