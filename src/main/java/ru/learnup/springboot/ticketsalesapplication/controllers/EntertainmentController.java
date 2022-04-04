package ru.learnup.springboot.ticketsalesapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnup.springboot.ticketsalesapplication.controllers.dto.EntertainmentDto;
import ru.learnup.springboot.ticketsalesapplication.mappers.MyMapper;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.services.EntertainmentService;
import ru.learnup.springboot.ticketsalesapplication.services.TicketService;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/entertainments")
public class EntertainmentController {

    private EntertainmentService entertainmentService;
    private TicketService ticketService;
    private MyMapper mapper;

    @Autowired
    public EntertainmentController(EntertainmentService entertainmentService, TicketService ticketService, MyMapper mapper) {
        this.entertainmentService = entertainmentService;
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @GetMapping
    public Collection<EntertainmentDto> getAll() {
        List<Entertainment> entertainmentList = entertainmentService.getAll();
        return entertainmentList.stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    public EntertainmentDto get(@PathVariable("id") Integer id) {
        Entertainment entertainment = entertainmentService.get(id);
        List<Ticket> ticketList = ticketService.getAllByEntertainment(entertainment);
//        entertainment.s

        final EntertainmentDto result = mapper.toDto(entertainment);

        return result;
    }

    @PostMapping
    public void create(@RequestBody EntertainmentDto entertainmentDto) {
        entertainmentService.add(mapper.toDomain(entertainmentDto));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody EntertainmentDto entertainmentDto) {
        entertainmentService.update(mapper.toDomain(entertainmentDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        entertainmentService.del(id);
    }

}
