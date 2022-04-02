package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.TicketRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository repository;

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public void printAllLike(String pattern) {
        for (TicketEntity ticketEntity : repository.findAllByNameLikeOrderById(pattern)) {
            System.out.println(ticketEntity);
        }
    }

    public TicketEntity getByEntNameAndData(String entertainmentName, LocalDate data) {
        return repository.findByNameData(entertainmentName, data);
    }

    public void addTickets(Ticket ticket) {
        repository.save(new TicketEntity(null,
                ticket.getData(),
                ticket.getCntTickets(),
                new EntertainmentEntity(ticket.getEntertainment().getId(),
                        ticket.getEntertainment().getName(),
                        ticket.getEntertainment().getDescr(),
                        ticket.getEntertainment().getAgeGroup(),
                        null)));
    }

    public void deleteByEntertainmentData(Integer entertainmentId, LocalDate data) {
        repository.deleteByEntData(entertainmentId, data);
    }

    @Transactional
    public void UpdateCntTickets(String entertainmentName, LocalDate data, Integer cntTickets) {

        TicketEntity ticketEntity = repository.findByNameData(entertainmentName, data);
        Optional<TicketEntity> optionalTicketEntity = Optional.ofNullable(ticketEntity);
        if (optionalTicketEntity.isPresent()){
            final Integer freeTickets = ticketEntity.getCntTickets();
            System.out.println("билетов сейчас " + freeTickets);

            if ((cntTickets > 0) && (freeTickets < cntTickets)) {
                System.out.println("Нет запрашиваемого количесва билетов. Осталось билетов " + freeTickets);
            } else {
                try {
                    final TicketEntity forUpdate = repository.getForUpdate(ticketEntity.getId());
                    System.out.println("Объект получен");
                    forUpdate.setCntTickets(freeTickets - cntTickets);
                    repository.save(forUpdate);
                    System.out.println("Объект записан");
                } catch (DataAccessException err) {
                    System.out.println("Объект уже был изменен!" + err.getMessage());
                }
            }
        } else {
            System.out.println("На дату " + data + " нет запланированных мероприятий " + entertainmentName);
        }
    }

    @Transactional
    public void BuyTickets(String entertainmentName, LocalDate data, Integer cntTickets) {
        UpdateCntTickets(entertainmentName, data, cntTickets);
    }

    @Transactional
    public void ReturnTickets(String entertainmentName, LocalDate data, Integer cntTickets) {
        UpdateCntTickets(entertainmentName, data, -cntTickets);
    }

}
