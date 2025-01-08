package com.dreamCompany.services.parkingSpotService.repository;

import com.dreamCompany.Models.enums.VehicleType;
import com.dreamCompany.Models.parkingspotModel.FourWheelerParkingSpot;
import com.dreamCompany.Models.parkingspotModel.TwoWheelerParkingSpot;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TwoWheelerParkingSpotRepo implements IParkingSpotRepo<TwoWheelerParkingSpot>{
 private final MongoTemplate mongoTemplate;

    @Override
    public TwoWheelerParkingSpot saveSpot(TwoWheelerParkingSpot twoWheelerParkingSpot) {
        return mongoTemplate.save(twoWheelerParkingSpot);
    }

    @Override
    public List<TwoWheelerParkingSpot> findAllAvailableParkingSpot() {
        Query query = new Query();
        Criteria criteria = Criteria.where("isAvailable").is(true)
                .and("vehicleType").is(VehicleType.FOUR_WHEELER);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, TwoWheelerParkingSpot.class);
    }

    @Override
    public List<TwoWheelerParkingSpot> findAllParkingSpot() {
        return mongoTemplate.findAll(TwoWheelerParkingSpot.class);
    }

    @Override
    public TwoWheelerParkingSpot findParkingSpot(String spotId) {
        Query query = new Query();
        Criteria criteria = Criteria.where("spotId").is(spotId);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, TwoWheelerParkingSpot.class);
    }

    @Override
    public void bulkSave(List<TwoWheelerParkingSpot> parkingSpots) {
        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, TwoWheelerParkingSpot.class);

        for (TwoWheelerParkingSpot spot : parkingSpots) {
            bulkOps.upsert(
                    new Query(Criteria.where("_id").is(spot.getSpotId())), // Match by ID
                    new Update()
                            .set("vehicleType", spot.getVehicleType())
                            .set("isAvailable", spot.isAvailable())
                            .set("vehicle", spot.getVehicle())
            );
        }

        bulkOps.execute();
    }

    @Override
    public long getCountOfAvailableParkingSpot() {
        Query query = new Query();
        Criteria criteria =  Criteria.where("isAvailable").is(true);
        query.addCriteria(criteria);
        return mongoTemplate.count(query, TwoWheelerParkingSpot.class);
    }

    @Override
    public long getCountOfTotalParkingSpot() {
        Query query = new Query();
        Criteria criteria = new Criteria();// Criteria.where("isAvailable").is(true);
        query.addCriteria(criteria);
        return mongoTemplate.count(query, TwoWheelerParkingSpot.class);
    }
}
