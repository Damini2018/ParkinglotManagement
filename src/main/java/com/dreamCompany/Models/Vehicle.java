package com.dreamCompany.Models;

import com.dreamCompany.Models.enums.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    private String id;
    private String vin;
    private VehicleType vehicleType;
}

