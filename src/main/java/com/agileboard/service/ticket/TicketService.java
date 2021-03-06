package com.agileboard.service.ticket;

import com.agileboard.model.Ticket;
import com.agileboard.model.User;
import com.agileboard.model.util.TicketStatus;
import org.bson.types.ObjectId;

import java.util.List;

public interface TicketService {
    Ticket changeStatus(ObjectId id, TicketStatus status);
    List<Ticket> findTicketsByUserId(ObjectId id);
}
