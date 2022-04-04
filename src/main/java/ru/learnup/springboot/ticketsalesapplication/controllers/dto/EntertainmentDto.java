package ru.learnup.springboot.ticketsalesapplication.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntertainmentDto {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String descr;

    @JsonProperty
    private String ageGroup;

    @JsonProperty
    private List<TicketDto> tickets;

}
