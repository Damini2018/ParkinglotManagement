package com.dreamCompany.Models.parkingspotModel;

import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document
@CompoundIndex(name = "spotId_vin_index", def = "{'spotId': 1, 'vehicle.vin': 1}", unique = true)
public class ParkingSpot {
    @Id
    private String spotId;
    private VehicleType vehicleType;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSpot() {
        this.setAvailable(true);
    }
    public ParkingSpot(VehicleType vehicleType) {
        this.setAvailable(true);
        this.setVehicleType(vehicleType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ParkingSpot that = (ParkingSpot) obj;
        return Objects.equals(spotId, that.spotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spotId);
    }
}
