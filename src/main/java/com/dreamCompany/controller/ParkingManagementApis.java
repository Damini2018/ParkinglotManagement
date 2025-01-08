package com.dreamCompany.controller;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.services.ParkingLotManager;
import com.dreamCompany.services.ticketService.repository.ITicketRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parking")
@RequiredArgsConstructor
public class ParkingManagementApis {
    private final ParkingLotManager parkingLotManager;
    private final ITicketRepo ticketRepo;

    @GetMapping
    public String getTotalAvailableSpots() {
        return parkingLotManager.getAvailableParking();
    }

    @GetMapping(path = "/capacity")
    public String getTotalSpots() {
        return parkingLotManager.getTotalParkingSpace();
    }

    @PostMapping(path = "/parkVehicle")
    public ResponseEntity parkVehicle(@RequestBody Vehicle vehicle) {
        parkingLotManager.entryVehicle(vehicle);
        return ResponseEntity.ok("Vehicle parked successfully.");
    }

    @PostMapping(path = "/exitvehicle")
    public ResponseEntity exitVehicle(@RequestBody Vehicle vehicle) {
        parkingLotManager.exitVehicle(vehicle);
        return ResponseEntity.ok("Vehicle exited successfully. ");
    }

    @PostMapping(path = "/calculateCharges")
    public ResponseEntity calculateParkingCharges(@RequestBody Ticket ticket) {
        ticketRepo.saveTicket(ticket);
        return ResponseEntity.ok("test");
    }
}
