package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.Models.parkingspotModel.TwoWheelerParkingSpot;
import com.dreamCompany.services.parkingSpotService.repository.IParkingSpotRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.dreamCompany.Models.enums.VehicleType.TWO_WHEELER;

@Service
@RequiredArgsConstructor
public class TwoWheelerParkingSpotsService implements IParkingSpotsService<TwoWheelerParkingSpot> {
    private final IParkingSpotRepo<TwoWheelerParkingSpot> parkingSpotRepo;
    private final static String PREFIX_TWO = "T-";

    @PostConstruct
    public void initializeParkingSpots() {
        List<TwoWheelerParkingSpot> twoWheelerParkingSpots = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            TwoWheelerParkingSpot spot = new TwoWheelerParkingSpot();
            spot.setSpotId(PREFIX_TWO + i);
            spot.setAvailable(true);
            spot.setVehicleType(TWO_WHEELER);
            twoWheelerParkingSpots.add(spot);
        }
        parkingSpotRepo.bulkSave(twoWheelerParkingSpots);
    }

    @Override
    public VehicleType getVehicleType() {
        return TWO_WHEELER;
    }

    @Override
    public List<? extends ParkingSpot> getParkingSpotList() {
        return List.of();
    }

    @Override
    public void addParkingSpotList(List<TwoWheelerParkingSpot> parkingSpots) {
        parkingSpotRepo.bulkSave(parkingSpots);
    }

    @Override
    public TwoWheelerParkingSpot saveParkingSpot(TwoWheelerParkingSpot parkingSpot) {
        return parkingSpotRepo.saveSpot(parkingSpot);
    }

    @Override
    public void markSpotUnavailable(ParkingSpot parkingSpot) {
        parkingSpot.setAvailable(false);
        parkingSpotRepo.saveSpot((TwoWheelerParkingSpot) parkingSpot);
    }

    @Override
    public void markSpotAvailable(ParkingSpot parkingSpot) {
        parkingSpot.setAvailable(true);
        parkingSpotRepo.saveSpot((TwoWheelerParkingSpot) parkingSpot);
    }

    @Override
    public void bookParkedSpotVehicle(ParkingSpot spot) {

    }

    @Override
    public void freeParkedSpotVehicle(String spotId) {

    }

    @Override
    public TwoWheelerParkingSpot findAvailableParkingSpot(VehicleType vehicleType) {
        return parkingSpotRepo.findAllAvailableParkingSpot().getFirst();
    }

    @Override
    public long getCountForUtilizedParking() {
        return 0;
    }

    @Override
    public TwoWheelerParkingSpot findParkingSpotBySpotId(String spotId) {
        return parkingSpotRepo.findParkingSpot(spotId);
    }

    @Override
    public long getTotalAvailableParking() {
        return parkingSpotRepo.findAllParkingSpot().stream().count();
    }

    @Override
    public long getTotalParkingSpace() {
        return parkingSpotRepo.findAllParkingSpot().stream().count();
    }

    @Override
    public void addExtraParkingSpot(int count) {
        List<TwoWheelerParkingSpot> twoWheelerParkingSpots = new ArrayList<>();
        long parking = parkingSpotRepo.findAllParkingSpot().stream().count();
        for (int i = (int) parking + 1; i <= parking + count; i++) {
            TwoWheelerParkingSpot spot = new TwoWheelerParkingSpot();
            spot.setSpotId(PREFIX_TWO + i);
            spot.setAvailable(true);
            spot.setVehicleType(VehicleType.FOUR_WHEELER);
            twoWheelerParkingSpots.add(spot);
        }
        parkingSpotRepo.bulkSave(twoWheelerParkingSpots);
    }

    @Override
    public List<TwoWheelerParkingSpot> findAvailableParkingSpot() {
        return parkingSpotRepo.findAllAvailableParkingSpot();
    }

    @Override
    public List<TwoWheelerParkingSpot> findAllParkingSpot() {
        return parkingSpotRepo.findAllParkingSpot();
    }

    @Override
    public TwoWheelerParkingSpot getParkingSpot(String spotId) {
        return parkingSpotRepo.findParkingSpot(spotId);
    }
}
