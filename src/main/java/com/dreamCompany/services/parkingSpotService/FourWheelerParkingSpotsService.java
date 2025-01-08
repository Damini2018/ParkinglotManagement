package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.VehicleContext;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.FourWheelerParkingSpot;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.Models.parkingspotModel.TwoWheelerParkingSpot;
import com.dreamCompany.services.parkingSpotService.repository.FourWheelerParkingSpotRepo;
import com.dreamCompany.services.parkingSpotService.repository.IParkingSpotRepo;
import com.dreamCompany.services.parkingSpotService.repository.TwoWheelerParkingSpotRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.dreamCompany.Models.enums.VehicleType.FOUR_WHEELER;

@Service
@RequiredArgsConstructor
public class FourWheelerParkingSpotsService implements IParkingSpotsService<FourWheelerParkingSpot> {
    private final IParkingSpotRepo<FourWheelerParkingSpot> parkingSpotRepo;

    @PostConstruct
    void initializeParkingSpots() {
        List<FourWheelerParkingSpot> fourWheelerParkingSpots = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            FourWheelerParkingSpot spot = new FourWheelerParkingSpot();
            spot.setSpotId("F-" + i);
            spot.setAvailable(true);
            spot.setVehicleType(VehicleType.FOUR_WHEELER);
            fourWheelerParkingSpots.add(spot);
        }
        parkingSpotRepo.bulkSave(fourWheelerParkingSpots);
    }

    @Override
    public VehicleType getVehicleType() {
        return FOUR_WHEELER;
    }

    @Override
    public List<? extends ParkingSpot> getParkingSpotList() {
        return List.of();
    }

    @Override
    public void addParkingSpotList(List<? extends ParkingSpot> parkingSpots) {

    }

    @Override
    public FourWheelerParkingSpot saveParkingSpot(FourWheelerParkingSpot parkingSpot) {
        return parkingSpotRepo.saveSpot(parkingSpot);
    }



    @Override
    public void markSpotUnavailable(ParkingSpot parkingSpot) {

    }

    @Override
    public void markSpotAvailable(ParkingSpot parkingSpot) {

    }

    @Override
    public void bookParkedSpotVehicle(ParkingSpot spot) {

    }

    @Override
    public void freeParkedSpotVehicle(String spotId) {

    }

    @Override
    public FourWheelerParkingSpot findAvailableParkingSpot(VehicleType vehicleType) {
        return parkingSpotRepo.findAllParkingSpot().getFirst();
    }

    @Override
    public long getCountForUtilizedParking() {
        return 0;
    }

    @Override
    public long getTotalAvailableParking() {
        return parkingSpotRepo.findAllAvailableParkingSpot().stream().count();
    }

    @Override
    public long getTotalParkingSpace() {
        return parkingSpotRepo.findAllParkingSpot().stream().count();
    }

    @Override
    public List<FourWheelerParkingSpot> findAvailableParkingSpot() {
        return parkingSpotRepo.findAllAvailableParkingSpot();
    }

    @Override
    public List<FourWheelerParkingSpot> findAllParkingSpot() {
        return parkingSpotRepo.findAllParkingSpot();
    }

    @Override
    public FourWheelerParkingSpot  getParkingSpot(String spotId) {
        return parkingSpotRepo.findParkingSpot(spotId);
    }
}
