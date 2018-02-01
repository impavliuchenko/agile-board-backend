package com.agileboard.model;

import com.agileboard.model.util.TicketStatus;
import lombok.Data;

@Data
public class Ticket {

    private String id;
    private String name;
    private String description;
    private TicketStatus status;

    public Ticket(String name, String description, TicketStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
