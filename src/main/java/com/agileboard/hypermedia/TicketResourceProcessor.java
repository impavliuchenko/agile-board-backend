package com.agileboard.hypermedia;

import com.agileboard.controller.api.system.TicketController;
import com.agileboard.model.Ticket;
import com.agileboard.model.util.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class TicketResourceProcessor implements ResourceProcessor<Resource<Ticket>> {

    private final RepositoryEntityLinks links;

    @Autowired
    public TicketResourceProcessor(RepositoryEntityLinks links) {
        this.links = links;
    }

    @Override
    public Resource<Ticket> process(Resource<Ticket> ticketResource) {
        Ticket ticket = ticketResource.getContent();

        if (ticket.getStatus() == TicketStatus.TODO || ticket.getStatus() == TicketStatus.DONE){
            ticketResource.add(linkTo(methodOn(TicketController.class).toInProgress(ticket.getId(), null))
                    .withRel("progress"));
        }

        if (ticket.getStatus() == TicketStatus.IN_PROGRESS){
            ticketResource.add(linkTo(methodOn(TicketController.class).toDone(ticket.getId(), null))
                    .withRel("done"));
            ticketResource.add(linkTo(methodOn(TicketController.class).toTodo(ticket.getId(), null))
                    .withRel("todo"));
        }

        if (ticket.getStatus() != TicketStatus.DONE){
            //update:  PATCH/PUT /tickets/{id}
            ticketResource.add(links.linkToSingleResource(ticket).withRel("update"));
            //delete
            ticketResource.add(links.linkToSingleResource(ticket).withRel("delete"));
        }
        return ticketResource;
    }
}
