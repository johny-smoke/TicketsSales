package ru.learnup.springboot.ticketsalesapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.interfaces.EntertainmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntertainmentService {
    private final EntertainmentRepository repository;

    @Autowired
    public EntertainmentService(EntertainmentRepository repository){
        this.repository = repository;
    }

    public void showAllEntertainments(){
        System.out.println(repository.findAll());
    }
    public void showEntertainmentByName(String name) { System.out.println(repository.getByName(name)); }

    public EntertainmentEntity getByName(String name) {
        return repository.getByName(name);
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

    @Transactional
    public void UpdateEntertainmentName(String entertainmentName, String newName) {

        EntertainmentEntity entertainmentEntity = repository.getByName(entertainmentName);
        Optional<EntertainmentEntity> optionalEntertainmentEntity = Optional.ofNullable(entertainmentEntity);
        if (optionalEntertainmentEntity.isPresent()){
            try {
                final EntertainmentEntity forUpdate = repository.getForUpdate(entertainmentEntity.getId());
                System.out.println("Объект получен");
                forUpdate.setName(newName);
                repository.save(forUpdate);
                System.out.println("Объект записан");
            } catch (DataAccessException err) {
                System.out.println("Объект уже был изменен!" + err.getMessage());
            }
        } else {
            System.out.println("Мероприятия " + entertainmentName + "не существует");
        }
    }

}
