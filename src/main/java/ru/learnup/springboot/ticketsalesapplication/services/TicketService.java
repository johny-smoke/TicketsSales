package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.TicketRepository;

@Service
public class TicketService {
    private TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository){
        this.repository = repository;
    }

/*    public void addTickets(Ticket ticket){
        repository.save(new TicketEntity(null,
                                         ticket.getData(),
                                         ticket.getCntTickets(),
                                         new EntertainmentEntity(ticket.getEntertainment().getName(),
                                                                 ticket.getEntertainment().getDescr(),
                                                                 ticket.getEntertainment().getAgeGroup())));
    }

 */
}
