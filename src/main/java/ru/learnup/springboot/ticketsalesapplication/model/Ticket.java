package ru.learnup.springboot.ticketsalesapplication.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Ticket {
    private LocalDateTime data;
    private Integer cntTickets;
    private Entertainment entertainment;

    public Ticket(Integer cntTickets, LocalDateTime data, Entertainment entertainment)
    {
        this.data = data;
        this.cntTickets = cntTickets;
        this.entertainment = entertainment;
    }
}
