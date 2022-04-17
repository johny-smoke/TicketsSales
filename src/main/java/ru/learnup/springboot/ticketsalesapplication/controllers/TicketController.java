package ru.learnup.springboot.ticketsalesapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnup.springboot.ticketsalesapplication.controllers.dto.TicketDto;
import ru.learnup.springboot.ticketsalesapplication.mappers.MyMapper;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.services.TicketService;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final MyMapper mapper;

    @Autowired
    public TicketController(TicketService ticketService, MyMapper mapper) {
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @GetMapping
    public Collection<TicketDto> getAll() {
        List<Ticket> ticketList = ticketService.getAll();
        return ticketList.stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @PutMapping("/{id}")
    public void buyTicket(@PathVariable("id") Integer id, @RequestBody TicketDto ticketDto) {
        ticketService.BuyTickets(id, mapper.toDomain(ticketDto));
    }
}
