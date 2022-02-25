package ru.learnup.springboot.ticketsalesapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.springboot.ticketsalesapplication.model.Entertainment;
import ru.learnup.springboot.ticketsalesapplication.services.EntertainmentService;

@SpringBootApplication
public class TicketsalesApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(TicketsalesApplication.class, args);

		EntertainmentService service = ctx.getBean(EntertainmentService.class);

		service.addEntertainment(new Entertainment("Дюна", "фантастика", "18+", "01.01.2022", 90));
		service.addEntertainment(new Entertainment("Metallica", "концерт по заявкам трудящихся", "21+", "15.07.2022", 50_000));
		service.addEntertainment(new Entertainment("Выставка грызунов", "выставка", "6+", "10.04.2022", 500));
		service.showAllEntertainments();
		service.buyTicket("Дюна", 23);
//		service.buyTicket("Дюна", -10);
		service.buyTicket("Metallica", 5_000);
		service.returnTicket("Metallica", 250);
		service.buyTicket("Выставка грызунов", 75);
		service.updEntertainmentData("Metallica", "15.08.2022");
		service.showAllEntertainments();

	}


}
