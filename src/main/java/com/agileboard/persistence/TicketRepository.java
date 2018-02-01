package com.agileboard.persistence;

import com.agileboard.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
