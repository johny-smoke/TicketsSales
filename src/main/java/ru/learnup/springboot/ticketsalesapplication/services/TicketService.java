package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.springboot.ticketsalesapplication.mappers.MyMapper;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.TicketRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final TicketRepository repository;
    private final MyMapper mapper;

    @Autowired
    public TicketService(TicketRepository repository, MyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Ticket> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole(\"USER\")")
    @Transactional
    public void BuyTickets(Integer id, Ticket ticket) {
        TicketEntity ticketEntity = repository.findAllById(id);
        final TicketEntity forUpdate = repository.getForUpdate(ticketEntity.getId());
        forUpdate.setCntTickets(ticket.getCntTickets());
        repository.save(forUpdate);

    }

}
