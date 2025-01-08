package com.dreamCompany.Models;

import com.dreamCompany.Models.enums.VehicleType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vehicles")
public class Vehicle {
    private String id;
    @Id
    private String vin;
    private VehicleType vehicleType;
}

