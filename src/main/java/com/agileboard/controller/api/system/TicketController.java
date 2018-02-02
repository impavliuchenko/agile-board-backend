package com.agileboard.controller.api.system;

import com.agileboard.model.util.TicketStatus;
import com.agileboard.service.ticket.TicketServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequestMapping("tickets")
public class TicketController {

    private final TicketServiceImpl ticketService;

    @Autowired
    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @PutMapping("/{id}/progress")
    @ResponseBody
    public PersistentEntityResource toInProgress(@PathVariable("id") ObjectId id,
                                                 PersistentEntityResourceAssembler asm){
        return asm.toFullResource(ticketService.changeStatus(id, TicketStatus.IN_PROGRESS));
    }

    @PutMapping("/{id}/done")
    @ResponseBody
    public PersistentEntityResource toDone(@PathVariable("id") ObjectId id,
                                                 PersistentEntityResourceAssembler asm){
        return asm.toFullResource(ticketService.changeStatus(id, TicketStatus.DONE));
    }

    @PutMapping("/{id}/todo")
    @ResponseBody
    public PersistentEntityResource toTodo(@PathVariable("id") ObjectId id,
                                           PersistentEntityResourceAssembler asm){
        return asm.toFullResource(ticketService.changeStatus(id, TicketStatus.TODO));
    }
}
