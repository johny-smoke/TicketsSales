package ru.learnup.springboot.ticketsalesapplication.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entertainments")
public class EntertainmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entertainments_id_seq")
    @SequenceGenerator(name = "entertainments_id_seq", sequenceName = "entertainments_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "descr", length = 128)
    private String descr;

    @Column(name = "agegroup", length = 10)
    private String ageGroup;

    @OneToMany (mappedBy = "entertainment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TicketEntity> ticketList;

    public void AddTicket(TicketEntity ticketEntity){
        this.ticketList.add(ticketEntity);
        ticketEntity.setEntertainment(this);
    }

    public void deleteTicket(TicketEntity ticketEntity) {
        this.ticketList.remove(ticketEntity);
        ticketEntity.setEntertainment(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("(%d) %s %s возрасная группа %s \n", id, name, descr, ageGroup));
        for (TicketEntity tickets : ticketList) {
            sb.append("на дату ").append(tickets.getData()).append(" билетов ").append(tickets.getCntTickets()).append("\n");
        }
        return sb.toString();
    }
}
