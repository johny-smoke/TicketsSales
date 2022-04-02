package ru.learnup.springboot.ticketsalesapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.model.Ticket;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.EntertainmentEntity;
import ru.learnup.springboot.ticketsalesapplication.repository.entities.TicketEntity;
import ru.learnup.springboot.ticketsalesapplication.services.EntertainmentService;
import ru.learnup.springboot.ticketsalesapplication.services.TicketService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan({"ru.learnup.springboot.ticketsalesapplication.repository.entities"})
public class TicketsalesApplication {

	public static void main(String[] args) {

		final ConfigurableApplicationContext ctx = SpringApplication.run(TicketsalesApplication.class, args);

		final EntertainmentService entertainmentService = ctx.getBean(EntertainmentService.class);
		final TicketService ticketService = ctx.getBean(TicketService.class);

//		ticketService.printAllLike("Metallica");

//		TicketEntity ticketEntity = ticketService.getByEntNameAndData("Metallica", LocalDate.of(2022, 7, 20));
//		System.out.println(ticketEntity.toString());

//      entertainmentService.UpdateEntertainmentName("rat show", "Rat Show");
//		ticketService.BuyTickets("Metallica", LocalDate.of(2022,7,15), 500);
//		ticketService.ReturnTickets("Metallica", LocalDate.of(2022,7,20), 100);
//		entertainmentService.delEntertainment(23);
//		ticketService.deleteByEntertainmentData(20, LocalDate.of(2022,1,15));

/*		Entertainment entertainment = new Entertainment(null, "rat show", "exhibition", "6+");
		List<Ticket> ticketList = new ArrayList<>();
		ticketList.add(new Ticket(LocalDate.of(2022,9,5), 400, entertainment));
		ticketList.add(new Ticket(LocalDate.of(2022,9,6), 450, entertainment));
		entertainmentService.addEntertainment(entertainment, ticketList);
*/
		entertainmentService.showAllEntertainments();
//		entertainmentService.showEntertainmentByName("Metallica");
	}
}
