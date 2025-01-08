package com.dreamCompany.services.ticketService.repository;

import com.dreamCompany.Models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepo extends MongoRepository<Ticket, String>, TicketRepoCustom {
}
