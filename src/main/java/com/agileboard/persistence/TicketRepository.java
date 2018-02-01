package com.agileboard.persistence;

import com.agileboard.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<User, String> {
}
