package com.dreamCompany.services.parkingSpotService;

import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.services.util.ListUtil;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ParkingSpotFactory {
    private final List<IParkingSpotStratedgy> parkingSpots;
    private Map<VehicleType, IParkingSpotStratedgy> parkingSpotMap;

    @PostConstruct
    public void set() {
        parkingSpotMap = new HashMap<>();
        for (IParkingSpotStratedgy parkingSpot : ListUtil.nullSafeEmptyList(parkingSpots)) {
            parkingSpotMap.put(parkingSpot.getVehicleType(), parkingSpot);
        }
    }

    public IParkingSpotStratedgy getParkingSpotBasedOnVehicle(VehicleType vehicleType) {
        return parkingSpotMap.getOrDefault(vehicleType, null);
    }
}
