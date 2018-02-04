package com.agileboard.service.ticket;

import com.agileboard.model.Role;
import com.agileboard.model.Ticket;
import com.agileboard.model.User;
import com.agileboard.model.util.TicketStatus;
import com.agileboard.persistence.TicketRepository;
import com.agileboard.persistence.UserRepository;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Ticket changeStatus(@NonNull ObjectId id, @NonNull TicketStatus status) {
        Ticket ticket = ticketRepository.findOne(id.toString());
        switch (status) {
            case TODO:
                ticket.setStatus(TicketStatus.TODO);
                break;
            case IN_PROGRESS:
                ticket.setStatus(TicketStatus.IN_PROGRESS);
                break;
            case DONE:
                ticket.setStatus(TicketStatus.DONE);
                break;
        }
        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findTicketsByUserId(@NonNull ObjectId id) {
        return ticketRepository.findTicketsByUserId(id);
    }

//    @PostConstruct
//    public void init() {
//        Date date = new Date();
//        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//
//        List<Ticket> tickets = new ArrayList<>();
//        tickets.add(
//                new Ticket(new ObjectId("5a74b153d9e8ae24e9eca234"), "fix bugs", "to do fixing", TicketStatus.TODO, formatForDateNow.format(date))
//        );
//        tickets.add(
//                new Ticket(new ObjectId("5a74b153d9e8ae24e9eca234"),"clean project", "make cleaning", TicketStatus.IN_PROGRESS, formatForDateNow.format(date))
//        );
//        tickets.add(
//                new Ticket(new ObjectId("5a74b153d9e8ae24e9eca235"), "add tests", "JUnit work", TicketStatus.TODO, formatForDateNow.format(date))
//        );
//        tickets.add(
//                new Ticket(new ObjectId("5a74b153d9e8ae24e9eca235"), "add system component", "angular4 working", TicketStatus.DONE, formatForDateNow.format(date))
//        );
//        List <Ticket> filledTicket = ticketRepository.save(tickets);
//
//
//        List<User> users = new ArrayList<>();
//        users.add(
//                new User(new ObjectId("5a74b153d9e8ae24e9eca234"), "impavlyuchenko@gmail.com", "pass", "Ivango",
//                        true, true, true, true,
//                        Arrays.asList( new Role()),
//                        Arrays.asList(filledTicket.get(0).getId(), filledTicket.get(1).getId() )
//                ));
//        users.add(
//                new User(new ObjectId("5a74b153d9e8ae24e9eca235"), "ahroh", "1234", "Anton",
//                        true, true, true, true,
//                        Arrays.asList( new Role()),
//                        Arrays.asList(filledTicket.get(2).getId(), filledTicket.get(3).getId())
//        ));
//        List<User> usersIds = userRepository.save(users);
//    }
}
