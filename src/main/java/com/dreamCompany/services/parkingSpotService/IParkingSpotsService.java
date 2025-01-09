package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

import java.util.List;

public interface IParkingSpotsService<T extends ParkingSpot> {

    VehicleType getVehicleType();

    List<? extends ParkingSpot> getParkingSpotList();

    void addParkingSpotList(List<? extends ParkingSpot> parkingSpots);

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

    T findParkingSpotBySpotId(String spotId);

    <T extends ParkingSpot> T getParkingSpot(String spotId);
}
