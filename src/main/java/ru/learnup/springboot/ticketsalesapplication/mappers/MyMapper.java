package ru.learnup.springboot.ticketsalesapplication.mappers;

import org.mapstruct.Mapper;
import ru.learnup.springboot.ticketsalesapplication.controllers.dto.EntertainmentDto;
import ru.learnup.springboot.ticketsalesapplication.controllers.dto.TicketDto;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;

@Mapper(componentModel = "spring")
public interface MyMapper {

    EntertainmentDto toDto(Entertainment entertainment);

    Entertainment toDomain(EntertainmentDto entertainmentDto);

    EntertainmentEntity toEntity(Entertainment entertainment);

    Entertainment toDomain(EntertainmentEntity entertainmentEntity);

    TicketDto toDto(Ticket ticket);

    Ticket toDomain(TicketDto ticketDto);

    TicketEntity toEntity(Ticket ticket);

    Ticket toDomain(TicketEntity ticketEntity);

}
