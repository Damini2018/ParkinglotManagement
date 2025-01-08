package com.dreamCompany.Models.parkingspotModel;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.dreamCompany.Models.enums.VehicleType.TWO_WHEELER;

@Data
@Document(collection = "twoWheelerParkingSpot")
public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(){
        super(TWO_WHEELER);
    }
}
