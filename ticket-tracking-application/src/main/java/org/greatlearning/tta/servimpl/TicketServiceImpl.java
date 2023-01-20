package org.greatlearning.tta.servimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.greatlearning.tta.entities.Ticket;
import org.greatlearning.tta.repositories.TicketRepository;
import org.greatlearning.tta.services.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket insertTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTikectById(int id) {
		ticketRepository.deleteById(id);

	}

	@Override
	public List<Ticket> getAllTicket() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(int id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket t) {
		// TODO Auto-generated method stub
		return ticketRepository.save(t);
	}

	@Override
	public List<Ticket> searchForTicket(String query) {
		List<Ticket> tickets = ticketRepository.searchTickets(query);
		return tickets.stream().collect(Collectors.toList());

	}

}
