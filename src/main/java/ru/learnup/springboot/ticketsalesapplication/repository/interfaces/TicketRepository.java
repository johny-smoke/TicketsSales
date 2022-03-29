package ru.learnup.springboot.ticketsalesapplication.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
