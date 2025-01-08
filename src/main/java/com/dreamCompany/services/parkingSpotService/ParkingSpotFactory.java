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
    private final List<IParkingSpotsService> parkingSpots;
    private Map<VehicleType, IParkingSpotsService> parkingSpotMap;

    @PostConstruct
    public void set() {
        parkingSpotMap = new HashMap<>();
        for (IParkingSpotsService parkingSpot : ListUtil.nullSafeEmptyList(parkingSpots)) {
            parkingSpotMap.put(parkingSpot.getVehicleType(), parkingSpot);
        }
    }

    public IParkingSpotsService getParkingSpotBasedOnVehicle(VehicleType vehicleType) {
        return parkingSpotMap.getOrDefault(vehicleType, null);
    }
}
