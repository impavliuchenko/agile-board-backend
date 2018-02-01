package com.agileboard.controller.api;


import com.agileboard.model.User;
import com.agileboard.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public List<User> getTickets(){
        return ticketService.getAllTickets();
    }
}
