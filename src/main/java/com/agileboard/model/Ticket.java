package com.agileboard.model;

import com.agileboard.model.util.TicketStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Ticket {
    @Id
    private String id;
    private String name;
    private String description;
    private TicketStatus status;
    private String date;

    public Ticket(String name, String description, TicketStatus status, String date) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.date = date;
    }
}
