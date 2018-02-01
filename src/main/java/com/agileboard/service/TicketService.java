package com.agileboard.service;

import com.agileboard.model.Role;
import com.agileboard.model.Ticket;
import com.agileboard.model.User;
import com.agileboard.model.util.TicketStatus;
import com.agileboard.persistence.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<User> getAllTickets(){
        return ticketRepository.findAll();
    }

//    @PostConstruct
//    public void init() {
//        List<User> items = new ArrayList<>();
//        items.add(
//                new User("ivango", "1", "Ivan",
//                        true, true, true, true,
//                        Arrays.asList( new Role()),
//                        Arrays.asList(
//                                new Ticket("authorization back", "to do user authorization", TicketStatus.DONE),
//                                new Ticket("registration back", "to do user registration", TicketStatus.IN_PROGRESS)))
//                );
//        items.add(
//                new User("iliza", "2", "Liza",
//                        true, true, true, true,
//                        Arrays.asList( new Role()),
//                        Arrays.asList(
//                                new Ticket("authorization front", "to do user authorization", TicketStatus.TODO),
//                                new Ticket("registration front", "to do user registration", TicketStatus.IN_PROGRESS)))
//        );
//
//        ticketRepository.save(items);
//    }
}
