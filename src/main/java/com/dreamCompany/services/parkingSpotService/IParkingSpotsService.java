package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

import java.util.List;

public interface IParkingSpotsService<T extends ParkingSpot> {

    VehicleType getVehicleType();

    List<? extends ParkingSpot> getParkingSpotList();

    void addParkingSpotList(List<? extends ParkingSpot> parkingSpots);

    //based on the find parking spot technique like find near elevator, find near exit gate, find near entry gate
    T saveParkingSpot(T parkingSpot);

    void markSpotUnavailable(ParkingSpot parkingSpot);

    void markSpotAvailable(ParkingSpot parkingSpot);

    void bookParkedSpotVehicle(ParkingSpot spot);
    void freeParkedSpotVehicle(String spotId);
    <T extends ParkingSpot> T findAvailableParkingSpot(VehicleType vehicleType);


    long getCountForUtilizedParking();

    long getTotalAvailableParking();

    long getTotalParkingSpace();

    List<T> findAvailableParkingSpot();
    List<T> findAllParkingSpot();

    <T extends ParkingSpot> T getParkingSpot(String spotId);
}
