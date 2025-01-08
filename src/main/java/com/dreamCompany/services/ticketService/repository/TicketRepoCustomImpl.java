package com.dreamCompany.services.ticketService.repository;

import com.dreamCompany.Models.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TicketRepoCustomImpl implements TicketRepoCustom {
    private final MongoTemplate mongoTemplate;

    @Override
    public void saveTicket(Ticket ticket) {
        mongoTemplate.save(ticket);
    }
}
