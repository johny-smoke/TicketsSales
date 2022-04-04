package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.springboot.ticketsalesapplication.mappers.MyMapper;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.TicketRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final TicketRepository repository;
    private MyMapper mapper;

    @Autowired
    public TicketService(TicketRepository repository, MyMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    private static Ticket toDomain(TicketEntity ticketEntity){
        return new Ticket(ticketEntity.getData(), ticketEntity.getCntTickets(), EntertainmentService.toDomain(ticketEntity.getEntertainment()));
    }

    private static List<Ticket> toDomain (List<TicketEntity> ticketEntityList){
        return ticketEntityList.stream()
                    .map(TicketService::toDomain)
                    .collect(Collectors.toList());
    }

    public List<Ticket> getAll() {
        return toDomain(repository.findAll());
    }

    public List<Ticket> getAllByEntertainment(Entertainment entertainment) {
        return toDomain(repository.findAllByEntertainmentId(entertainment.getId()));
    }
}
