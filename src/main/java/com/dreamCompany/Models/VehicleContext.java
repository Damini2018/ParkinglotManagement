package com.dreamCompany.Models;

import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import lombok.Data;

@Data
public class VehicleContext {
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Ticket ticket;
    private VehicleType vehicleType;
    private Payment payment;

    public VehicleContext(VehicleType vehicleType) {
        this.setVehicleType(vehicleType);
    }
}
