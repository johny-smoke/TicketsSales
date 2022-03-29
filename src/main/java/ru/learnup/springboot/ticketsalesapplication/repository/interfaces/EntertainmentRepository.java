package ru.learnup.springboot.ticketsalesapplication.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;

public interface EntertainmentRepository extends JpaRepository <EntertainmentEntity, Integer>{
    public void deleteById(Integer id);
    }