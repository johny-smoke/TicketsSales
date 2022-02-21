package ru.learnup.springboot.ticketsalesapplication;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.springboot.ticketsalesapplication.model.Event;
import ru.learnup.springboot.ticketsalesapplication.services.EventService;

@SpringBootApplication
public class TicketsalesApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(TicketsalesApplication.class, args);

		EventService service = ctx.getBean(EventService.class);

		service.addEvent(new Event("Дюна", "фантастика", "18+", 90));
		service.addEvent(new Event("Metallica", "концерт по заявкам трудящихся", "21+", 50_000));
		service.addEvent(new Event("Выставка грызунов", "выставка", "6+", 500));
		service.showAllEvents();
		service.buyTicket("Дюна", 23);
//		service.buyTicket("Дюна", -10);
		service.buyTicket("Metallica", 5_000);
		service.returnTicket("Metallica", 250);
		service.buyTicket("Выставка грызунов", 75);
		service.showAllEvents();

	}


}
