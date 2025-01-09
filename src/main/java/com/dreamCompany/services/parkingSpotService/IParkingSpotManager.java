package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;

public interface IParkingSpotManager<T extends ParkingSpot> {
    <T extends ParkingSpot> T findAvailableParkingSpot(VehicleType vehicleType);

    <T extends ParkingSpot> T saveParkingSpot(ParkingSpot parkingSpot);

    long getCountOfAvailableSpot(VehicleType vehicleType);

    long getCountOfTotalSpot(VehicleType vehicleType);
}
