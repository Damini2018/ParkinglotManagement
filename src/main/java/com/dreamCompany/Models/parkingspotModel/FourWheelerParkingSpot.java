package com.dreamCompany.Models.parkingspotModel;

import static com.dreamCompany.Models.enums.VehicleType.FOUR_WHEELER;

public class FourWheelerParkingSpot extends ParkingSpot {
    public FourWheelerParkingSpot(){
        super();
        this.setVehicleType(FOUR_WHEELER);
        this.setAvailable(true);

    }
}
