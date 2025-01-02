package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.Ticket;
import com.dreamCompany.Models.Vehicle;
import com.dreamCompany.Models.enums.ChargesType;
import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.FourWheelerParkingSpot;
import com.dreamCompany.Models.parkingspotModel.ParkingSpot;
import com.dreamCompany.Models.parkingspotModel.TwoWheelerParkingSpot;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.dreamCompany.Models.enums.VehicleType.TWO_WHEELER;

@Service
public class TwoWheelerParkingSpotStratedgy implements IParkingSpotStratedgy {
    private List<TwoWheelerParkingSpot> twoWheelerParkingSpots;

    @PostConstruct
    public void initializeParkingSpots() {
        twoWheelerParkingSpots = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            TwoWheelerParkingSpot spot = new TwoWheelerParkingSpot();
            spot.setId("F-" + i);
            spot.setAvailable(true);
            spot.setVehicleType(TWO_WHEELER);
            twoWheelerParkingSpots.add(spot);
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
        return TWO_WHEELER;
    }

    @Override
    public List<TwoWheelerParkingSpot> getParkingSpotList() {
        return twoWheelerParkingSpots;
    }

    @Override
    public void addParkingSpotList(List<? extends ParkingSpot> parkingSpots) {
        if (parkingSpots != null && !parkingSpots.isEmpty() && parkingSpots.get(0) instanceof TwoWheelerParkingSpot) {
            this.twoWheelerParkingSpots = (List<TwoWheelerParkingSpot>) parkingSpots;
        } else {
            throw new IllegalArgumentException("Invalid parking spot list provided for Two-Wheeler Parking Strategy.");
        }
    }

    @Override
    public void addParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof TwoWheelerParkingSpot) {
            twoWheelerParkingSpots.add((TwoWheelerParkingSpot) parkingSpot);
        }
    }

    @Override
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof TwoWheelerParkingSpot) {
            twoWheelerParkingSpots.remove((TwoWheelerParkingSpot) parkingSpot);
        }
    }

    @Override
    public void markSpotUnavailable(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof FourWheelerParkingSpot) {
            twoWheelerParkingSpots.stream().filter(spot -> spot.getId().equals(parkingSpot.getId()))
                    .findFirst().ifPresent(spot -> spot.setAvailable(false));
        }
    }

    @Override
    public void markSpotAvailable(ParkingSpot parkingSpot) {
        if (parkingSpot instanceof FourWheelerParkingSpot) {
            twoWheelerParkingSpots.stream().filter(spot -> spot.getId().equals(parkingSpot.getId()))
                    .findFirst().ifPresent(spot -> spot.setAvailable(true));
        }
    }

    @Override
    public Ticket bookSpotForVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            Ticket ticket = new Ticket();
            ticket.setVin(vehicle.getVin());
            ticket.setVehicleType(vehicle.getVehicleType());
            ticket.setStartTime(System.currentTimeMillis());
            ticket.setChargesType(ChargesType.MINUTE);
            twoWheelerParkingSpots.stream()
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
    public void removeBookedSpotByVehicle(Vehicle vehicle) {
        twoWheelerParkingSpots.stream().filter(spot -> vehicle.equals(spot.getVehicle())).findFirst().ifPresent(spot -> removeBookedSpot(spot));
    }

    @Override
    public void removeBookedSpotByVehicle(Ticket ticket) {
        twoWheelerParkingSpots.stream().filter(spot -> ticket.getSpotId().equals(spot.getId())).findFirst().ifPresent(spot -> removeBookedSpot(spot));

    }

    @Override
    public long getCountForUtilizedParking() {
        long count = twoWheelerParkingSpots.stream().filter(spot -> !spot.isAvailable()).count();
        return count;
    }

    @Override
    public void removeBookedSpot(ParkingSpot parkingSpot) {
        twoWheelerParkingSpots.stream().filter(spot -> spot.equals(parkingSpot)).findFirst().ifPresent(spot -> removeBookedSpotBySpot(spot));
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
        System.out.println("No TwoWheeler available spot for vehicle");
    }
}
