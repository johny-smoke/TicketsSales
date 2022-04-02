package ru.learnup.springboot.ticketsalesapplication.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Ticket {
    private LocalDate data;
    private Integer cntTickets;
    private Entertainment entertainment;

    public Ticket(LocalDate data, Integer cntTickets, Entertainment entertainment)
    {
        this.data = data;
        this.cntTickets = cntTickets;
        this.entertainment = entertainment;
    }
}
