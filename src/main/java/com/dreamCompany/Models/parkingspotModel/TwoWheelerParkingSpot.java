package com.dreamCompany.Models.parkingspotModel;

import static com.dreamCompany.Models.enums.VehicleType.TWO_WHEELER;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(){
        super();
        this.setVehicleType(TWO_WHEELER);
        this.setAvailable(true);
    }
}
