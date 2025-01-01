package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.ChargesType;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.FourWheelerParkingSpot;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.dreamCompany.Models.enums.VehicleType.FOUR_WHEELER;

@Service
public class FourWheelerParkingSpotStratedgy implements IParkingSpotStratedgy {
    private List<FourWheelerParkingSpot> fourWheelerParkingSpots;

    @PostConstruct
    public void initializeParkingSpots() {
        fourWheelerParkingSpots = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            FourWheelerParkingSpot spot = new FourWheelerParkingSpot();
            spot.setId("F-" + i);
            spot.setAvailable(true);
            spot.setVehicleType(VehicleType.FOUR_WHEELER);
            fourWheelerParkingSpots.add(spot);
        }
    }

    @Override
    public boolean parkVehicle() {
        return false;
    }

    @Override
    public boolean unParkVehicle() {
        return false;
    }

    @Override
    public boolean markAvailibility() {
        return false;
    }

    @Override
    public VehicleType getVehicleType() {
        return FOUR_WHEELER;
    }

    @Override
    public List<FourWheelerParkingSpot> getParkingSpotList() {
        return fourWheelerParkingSpots;
    }

    @Override
    public void setParkingSpotList(List<? extends ParkingSpot> parkingSpots) {
        if (parkingSpots != null && !parkingSpots.isEmpty() && parkingSpots.get(0) instanceof FourWheelerParkingSpot) {
            this.fourWheelerParkingSpots = (List<FourWheelerParkingSpot>) parkingSpots;
        } else {
            throw new IllegalArgumentException("Invalid parking spot list provided for Four-Wheeler Parking Strategy.");
        }
    }


    @Override
    public void addParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof FourWheelerParkingSpot) {
            fourWheelerParkingSpots.add((FourWheelerParkingSpot) parkingSpot);
        }
    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof FourWheelerParkingSpot) {
            fourWheelerParkingSpots.remove((FourWheelerParkingSpot) parkingSpot);
        }
    }

    @Override
    public void markSpotUnavailable(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof FourWheelerParkingSpot) {
            fourWheelerParkingSpots.stream().filter(spot -> spot.getId().equals(parkingSpot.getId()))
                    .findFirst().ifPresent(spot -> spot.setAvailable(false));
        }
    }

    @Override
    public void markSpotAvailable(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof FourWheelerParkingSpot) {
            fourWheelerParkingSpots.stream().filter(spot -> spot.getId().equals(parkingSpot.getId()))
                    .findFirst().ifPresent(spot -> spot.setAvailable(true));
        }
    }

    @Override
    public long getCountForUtilizedParking() {
        long count = fourWheelerParkingSpots.stream().filter(spot -> !spot.isAvailable()).count();
        return count;
    }

    @Override
    public Ticket bookSpotForVehicle(Vehicle vehicle) {
        long count = fourWheelerParkingSpots.stream().filter(ParkingSpot::isAvailable).count();
        if (vehicle != null) {
            Ticket ticket = new Ticket();
            ticket.setVin(vehicle.getVin());
            ticket.setVehicleType(vehicle.getVehicleType());
            ticket.setStartTime(System.currentTimeMillis());
            ticket.setChargesType(ChargesType.MINUTE);
            fourWheelerParkingSpots.stream()
                    .filter(ParkingSpot::isAvailable)
                    .findFirst()
                    .map(spot -> {
                        bookSpotForVehicle(vehicle, spot, ticket);

                        return spot;
                    })
                    .orElseGet(() -> {
                        handleNoSpotAvailable();
                        return null;
                    });
            return ticket;
        } else {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
    }

    @Override
    public void removeBookedSpot(ParkingSpot parkingSpot) {
        fourWheelerParkingSpots.stream().filter(spot -> spot.equals(parkingSpot)).findFirst().ifPresent(spot -> removeBookedSpotBySpot(spot));
    }

    @Override
    public void removeBookedSpotByVehicle(Vehicle vehicle) {
        fourWheelerParkingSpots.stream().filter(spot -> vehicle.equals(spot.getVehicle())).findFirst().ifPresent(spot -> removeBookedSpot(spot));
    }

    @Override
    public void removeBookedSpotByVehicle(Ticket ticket) {
        fourWheelerParkingSpots.stream().filter(spot -> ticket.getSpotId().equals(spot.getId())).findFirst().ifPresent(spot -> removeParkingSpot(spot));
    }

    private void removeBookedSpotBySpot(ParkingSpot parkingSpot) {
        parkingSpot.setAvailable(true);
        parkingSpot.setVehicle(null);
    }

    private void bookSpotForVehicle(Vehicle vehicle, ParkingSpot parkingSpot, Ticket ticket) {
        parkingSpot.setVehicleType(vehicle.getVehicleType());
        parkingSpot.setAvailable(false);
        parkingSpot.setVehicle(vehicle);
        ticket.setSpotId(parkingSpot.getId());
    }

    private void handleNoSpotAvailable() {
        System.out.println("No FourWheeler available spot for vehicle");
    }
}
