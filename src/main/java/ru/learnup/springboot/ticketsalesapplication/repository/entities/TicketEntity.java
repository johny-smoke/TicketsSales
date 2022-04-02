package ru.learnup.springboot.ticketsalesapplication.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_id_seq")
    @SequenceGenerator(name = "tickets_id_seq", sequenceName = "tickets_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "cnt")
    private Integer cntTickets;

    @ManyToOne
    @JoinColumn(name = "ent_id")
    private EntertainmentEntity entertainment;

    @Override
    public String toString() {
        return String.format("(%d) %s на дату %s билетов %d", id, entertainment.getName(), data, cntTickets);
    }
}
