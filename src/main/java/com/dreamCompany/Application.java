package com.dreamCompany;

import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.services.ParkingLotManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        ParkingLotManager parkingLotManager = context.getBean(ParkingLotManager.class);

        //parkingLotManager.initializeParkingLot();
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.TWO_WHEELER);
        vehicle.setVin("VI234");
        parkingLotManager.entryVehicle(vehicle);
        parkingLotManager.exitVehicle(vehicle);
    }
}