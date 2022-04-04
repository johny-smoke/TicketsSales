package ru.learnup.springboot.ticketsalesapplication.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    List<TicketEntity> findAllByEntertainmentId(Integer id);

    @Query(value = "from TicketEntity e where e.entertainment.name = :name")
    List<TicketEntity> findAllByNameLikeOrderById(String name);

    @Query(value = "from TicketEntity e where e.entertainment.name = :name and e.data = :data")
    TicketEntity findByNameData(String name, LocalDate data);

    @Modifying
    @Transactional
    @Query(value = "delete from TicketEntity e where e.entertainment.id = :entertainmentId and e.data = :data")
    void deleteByEntData(Integer entertainmentId, LocalDate data);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("from TicketEntity b where b.id = :id")
    TicketEntity getForUpdate(Integer id);
}
