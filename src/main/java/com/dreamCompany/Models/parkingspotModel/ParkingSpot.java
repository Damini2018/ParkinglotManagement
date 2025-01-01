package com.dreamCompany.Models.parkingspotModel;

import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import lombok.Data;

import java.util.Objects;

@Data
public class ParkingSpot {
    private String id;
    private VehicleType vehicleType;
    private boolean isAvailable;
    private Vehicle vehicle;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ParkingSpot that = (ParkingSpot) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
