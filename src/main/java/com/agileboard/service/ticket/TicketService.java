package com.agileboard.service.ticket;

import com.agileboard.model.Ticket;
import com.agileboard.model.util.TicketStatus;
import org.bson.types.ObjectId;

public interface TicketService {
    Ticket changeStatus(ObjectId id, TicketStatus status);
}
