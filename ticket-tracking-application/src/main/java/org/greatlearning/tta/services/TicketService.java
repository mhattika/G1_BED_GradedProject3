package org.greatlearning.tta.services;

import java.util.List;

import org.greatlearning.tta.entities.Ticket;

public interface TicketService {

	Ticket insertTicket(Ticket ticket);

	void deleteTikectById(int id);

	List<Ticket> getAllTicket();

	Ticket getTicketById(int id);

	Ticket updateTicket(Ticket t);

	List<Ticket> searchForTicket(String query);

}
