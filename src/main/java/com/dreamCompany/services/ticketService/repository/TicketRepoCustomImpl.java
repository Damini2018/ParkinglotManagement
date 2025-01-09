package com.dreamCompany.services.ticketService.repository;

import com.dreamCompany.Models.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TicketRepoCustomImpl implements ITicketRepo {
    private final MongoTemplate mongoTemplate;

    @Override
    public Ticket findTicketByVehicleId(String vin) {
        Query query = new Query();
        Criteria criteria = Criteria.where("vin").is(vin);

        query.addCriteria(criteria);
        System.out.println("The query to fetch ticket "+query);
        return mongoTemplate.findOne(query, Ticket.class);
    }

    @Override
    public void saveTicket(Ticket ticket) {
        mongoTemplate.save(ticket);
    }
}
