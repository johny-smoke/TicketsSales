package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.EntertainmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntertainmentService {
    private EntertainmentRepository repository;

    @Autowired
    public EntertainmentService(EntertainmentRepository repository){
        this.repository = repository;
    }
    public void showAllEntertainments(){
        System.out.println(repository.findAll());
    }
    public void delEntertainment(Integer entertainmentId){
        repository.deleteById(entertainmentId);
    }

    public void addEntertainment(Entertainment entertainment, List<Ticket> ticketList){
        List<TicketEntity> ticketEntity = new ArrayList<>();
        final EntertainmentEntity entertainmentEntity = new EntertainmentEntity(null,
                                                                          entertainment.getName(),
                                                                          entertainment.getDescr(),
                                                                          entertainment.getAgeGroup(),
                                                                          ticketEntity);
        for (Ticket ticket: ticketList) {
            ticketEntity.add(new TicketEntity(null, ticket.getData(), ticket.getCntTickets(), entertainmentEntity));
        }
        repository.save(entertainmentEntity);
    }
}
