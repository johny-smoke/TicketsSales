package ru.learnup.springboot.ticketsalesapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.services.EntertainmentService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan({"ru.learnup.springboot.ticketsalesapplication.repository.entities"})
public class TicketsalesApplication {

	public static void main(String[] args) {

		final ConfigurableApplicationContext ctx = SpringApplication.run(TicketsalesApplication.class, args);

		final EntertainmentService entertainmentService = ctx.getBean(EntertainmentService.class);

		Entertainment entertainment = new Entertainment("Dune", "film", "18+");
		List<Ticket> ticketList = new ArrayList<>();
		ticketList.add(new Ticket(90, LocalDateTime.of(2022,1,10, 20, 30), entertainment));
		ticketList.add(new Ticket(80, LocalDateTime.of(2022,1,11, 20, 00), entertainment));
		ticketList.add(new Ticket(85, LocalDateTime.of(2022,1,12, 19, 30), entertainment));
		entertainmentService.addEntertainment(entertainment, ticketList);

		entertainment = new Entertainment("Metallica", "concert", "21+");
		ticketList = new ArrayList<>();
		ticketList.add(new Ticket(50_000, LocalDateTime.of(2022,7,15, 22, 30), entertainment));
		ticketList.add(new Ticket(75_000, LocalDateTime.of(2022,7,20, 23, 00), entertainment));
		entertainmentService.addEntertainment(entertainment, ticketList);

		entertainmentService.showAllEntertainments();
	}
}
