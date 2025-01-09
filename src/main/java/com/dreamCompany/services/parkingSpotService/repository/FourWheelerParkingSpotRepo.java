package com.dreamCompany.services.parkingSpotService.repository;

import com.dreamCompany.Models.parkingspotModel.FourWheelerParkingSpot;
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
public class FourWheelerParkingSpotRepo implements IParkingSpotRepo<FourWheelerParkingSpot> {
    private final MongoTemplate mongoTemplate;

    @Override
    public FourWheelerParkingSpot saveSpot(FourWheelerParkingSpot fourWheelerParkingSpot) {
        return mongoTemplate.save(fourWheelerParkingSpot);
    }

    @Override
    public List<FourWheelerParkingSpot> findAllAvailableParkingSpot() {
        Query query = new Query();
        Criteria criteria = Criteria.where("isAvailable").is(true);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, FourWheelerParkingSpot.class);
    }

    @Override
    public List<FourWheelerParkingSpot> findAllParkingSpot() {
        return mongoTemplate.findAll(FourWheelerParkingSpot.class);
    }

    @Override
    public List<FourWheelerParkingSpot> findAllUtilizedParkingSpot() {
        Query query = new Query();
        Criteria criteria = Criteria.where("isAvailable").is(false);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, FourWheelerParkingSpot.class);
    }

    @Override
    public FourWheelerParkingSpot findParkingSpot(String spotId) {
        Query query = new Query();
        Criteria criteria = Criteria.where("spotId").is(spotId);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, FourWheelerParkingSpot.class);
    }

    @Override
    public void bulkSave(List<FourWheelerParkingSpot> parkingSpots) {
        BulkOperations bulkOps = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, FourWheelerParkingSpot.class);

        for (FourWheelerParkingSpot spot : parkingSpots) {
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
        Criteria criteria = Criteria.where("isAvailable").is(true);
        query.addCriteria(criteria);
        return mongoTemplate.count(query, FourWheelerParkingSpot.class);
    }

    @Override
    public long getCountOfTotalParkingSpot() {
        Query query = new Query();
        Criteria criteria = new Criteria();// Criteria.where("isAvailable").is(true);
        query.addCriteria(criteria);
        return mongoTemplate.count(query, FourWheelerParkingSpot.class);
    }
}
