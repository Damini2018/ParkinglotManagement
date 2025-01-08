package com.dreamCompany.services;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.services.entryservices.IEntryGateService;
import com.dreamCompany.services.exitservices.ExitGateServiceImpl;
import com.dreamCompany.services.exitservices.IExitGateService;
import com.dreamCompany.services.parkingSpotService.ParkingSpotManager;
import com.dreamCompany.services.priceCalculationservice.PriceCalculatorManager;
import com.dreamCompany.services.ticketService.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotManager {
    private final IExitGateService exitGateService;
    private final IEntryGateService entryGateService;


    public void exitVehicle(Vehicle vehicle) {
        exitGateService.letGoVehicle(vehicle);
    }

    public void entryVehicle(Vehicle vehicle) {
        entryGateService.issueTicket(vehicle);
    }


    public String getAvailableParking() {
        long twoWheeler = entryGateService.getTotalAvailableSpot(VehicleType.TWO_WHEELER);
        long fourWheeler = entryGateService.getTotalAvailableSpot(VehicleType.FOUR_WHEELER);
        return "Two wheeler parking space available = " + twoWheeler + " and Four wheeler parking space available = " + fourWheeler;
    }

    public String getTotalParkingSpace() {
        long twoWheeler = entryGateService.getTotalParkingSpot(VehicleType.TWO_WHEELER);
        long fourWheeler = entryGateService.getTotalParkingSpot(VehicleType.FOUR_WHEELER);
        return "Two wheeler parking space available = " + twoWheeler + " and Four wheeler parking space available = " + fourWheeler;
    }

//    public double calculatePrice(Ticket ticket) {
//        return priceCalculatorManager.calculatePrice(ticket);
//    }
//    public ParkingSpot findAvailableParkingSpot(){
//
//    }
}
