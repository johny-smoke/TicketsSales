package ru.learnup.springboot.ticketsalesapplication.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;

import javax.persistence.LockModeType;

public interface EntertainmentRepository extends JpaRepository <EntertainmentEntity, Integer> {

    void deleteById(Integer id);

    EntertainmentEntity getByName(String name);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("from EntertainmentEntity e where e.id = :id")
    EntertainmentEntity getForUpdate(Integer id);
}