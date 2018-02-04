package com.agileboard.model;

import com.agileboard.model.util.TicketStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Identifiable;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Document
public class Ticket implements Identifiable<Serializable> {
    @Id
    private ObjectId id;
    private ObjectId userId;
    private String name;
    private String description;
    private TicketStatus status;
    private String date;

    public Ticket(ObjectId userId, String name, String description, TicketStatus status, String date) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.date = date;
    }
}
