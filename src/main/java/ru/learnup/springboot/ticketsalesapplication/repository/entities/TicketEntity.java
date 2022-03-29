package ru.learnup.springboot.ticketsalesapplication.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime data;

    @Column(name = "cnt")
    private Integer cntTickets;

    /*
    public TicketEntity(LocalDateTime data, Integer cntTickets){
        this.data = data;
        this.cntTickets = cntTickets;
    }
    (cascade = CascadeType.ALL)
     */

    @ManyToOne
    @JoinColumn(name = "ent_id")
    private EntertainmentEntity entertainment;

    @Override
    public String toString() {
        return String.format("(%d) %s билетов %d", id, entertainment.getName(), cntTickets);
    }
}
