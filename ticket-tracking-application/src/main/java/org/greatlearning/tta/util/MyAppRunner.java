package org.greatlearning.tta.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.greatlearning.tta.entities.Ticket;
import org.greatlearning.tta.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements CommandLineRunner {
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void run(String... args) throws Exception {

		Ticket t1 = new Ticket();
		t1.setTitle("RITM001");
		t1.setShortDescription("Ticket Create new Project/study Setup");
		t1.setCreatedOn(LocalDate.now());
		t1.setContent("content text");
		ticketRepository.save(t1);

		Ticket t2 = new Ticket();
		t2.setTitle("RITM002");
		t2.setShortDescription("Ticket for New user account creation");
		t2.setCreatedOn(LocalDate.now());
		t2.setContent("content text");
		ticketRepository.save(t2);

		Ticket t3 = new Ticket();
		t3.setTitle("RITM003");
		t3.setShortDescription("Ticket for password re-set");
		t3.setCreatedOn(LocalDate.now());
		t3.setContent("content text");
		ticketRepository.save(t3);

		Ticket t4 = new Ticket();
		t4.setTitle("VTI002");
		t4.setShortDescription("Ticket for testing purpose");
		t4.setCreatedOn(LocalDate.now());
		t4.setContent("content text");
		ticketRepository.save(t4);

	}

}
