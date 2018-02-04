package com.agileboard.persistence;

import com.agileboard.model.Ticket;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findTicketsByUserId(ObjectId id);
}


//    var result = db.user.findOne({"_id":ObjectId("5a74b153d9e8ae24e9eca237")},{"tickets":1});
//        db.ticket.find({"_id":{"$in":result["tickets"]}})