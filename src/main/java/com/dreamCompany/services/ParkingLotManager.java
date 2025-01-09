package com.dreamCompany.services;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.services.entryservices.IEntryGateService;
import com.dreamCompany.services.exitservices.IExitGateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotManager {
    private final IExitGateService exitGateService;
    private final IEntryGateService entryGateService;
    private final IParkingSystemService parkingSystemService;

    public void exitVehicle(Vehicle vehicle, String paymentMode, String chargeBasis) {
        exitGateService.letGoVehicle(vehicle, paymentMode, chargeBasis);
    }

    public void exitVehicle(Ticket ticket, String paymentMode, String chargeBasis) {
        exitGateService.letGoVehicle(ticket, paymentMode, chargeBasis);
    }


    public Ticket entryVehicle(Vehicle vehicle) {
        return entryGateService.issueTicket(vehicle);
    }


    public String getAvailableParking() {
        long twoWheeler = entryGateService.getTotalAvailableSpot(VehicleType.TWO_WHEELER);
        long fourWheeler = entryGateService.getTotalAvailableSpot(VehicleType.FOUR_WHEELER);
        return "Two wheeler parking space available = " + twoWheeler + " and Four wheeler parking space available = " + fourWheeler;
    }

    public String getTotalParkingSpace() {
        long twoWheeler = entryGateService.getTotalParkingSpot(VehicleType.TWO_WHEELER);
        long fourWheeler = entryGateService.getTotalParkingSpot(VehicleType.FOUR_WHEELER);
        return "Two wheeler parking space capacity = " + twoWheeler + " and Four wheeler parking space capacity = " + fourWheeler;
    }

    public void addExtraParkingSpot(VehicleType vehicleType, int total) {
        System.out.println("The total parking for "+vehicleType+" is = "+entryGateService.getTotalParkingSpot(vehicleType));
        parkingSystemService.addExtraParkingSpot(vehicleType, total);
        System.out.println("The total parking for "+vehicleType+" is after adding extra "+total+" = "+entryGateService.getTotalParkingSpot(vehicleType));

    }
}
