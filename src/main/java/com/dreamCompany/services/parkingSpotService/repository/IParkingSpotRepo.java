package com.dreamCompany.services.parkingSpotService.repository;

import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

import java.util.List;

public interface IParkingSpotRepo<T extends ParkingSpot> {
    T saveSpot(T t);

    List<T> findAllAvailableParkingSpot();

    List<T> findAllParkingSpot();
    List<T> findAllUtilizedParkingSpot();

    T findParkingSpot(String spotId);

    void bulkSave(List<T> parkingSpots);

    long getCountOfAvailableParkingSpot();

    long getCountOfTotalParkingSpot();
}
