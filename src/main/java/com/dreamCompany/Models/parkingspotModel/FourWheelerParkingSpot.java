package com.dreamCompany.Models.parkingspotModel;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.dreamCompany.Models.enums.VehicleType.FOUR_WHEELER;

@Data
@Document(collection = "fourWheelerParkingSpot")
public class FourWheelerParkingSpot extends ParkingSpot {
    public FourWheelerParkingSpot() {
        super(FOUR_WHEELER);
    }
}
