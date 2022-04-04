package ru.learnup.springboot.ticketsalesapplication.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TicketDto {

    @JsonProperty
    private LocalDate data;

    @JsonProperty
    private Integer cntTickets;

    @JsonProperty
    private String entertainmentName;

}