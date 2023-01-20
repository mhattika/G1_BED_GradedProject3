package org.greatlearning.tta.controllers;

import java.util.List;

import org.greatlearning.tta.entities.Ticket;
import org.greatlearning.tta.services.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	@GetMapping("/")
	public String greet() {
		return "welcome"; // view file jsp file
	}

	@GetMapping("/tickets")
	public String listEmployees(Model model) {
		List<Ticket> tickets = ticketService.getAllTicket();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable("id") int id) {
		ticketService.deleteTikectById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}

	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.insertTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable("id") int id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable("id") int id, @ModelAttribute("ticket") Ticket ticket) {
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setShortDescription(ticket.getShortDescription());
		existingTicket.setCreatedOn(ticket.getCreatedOn());
		ticketService.insertTicket(existingTicket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicketForm(@PathVariable("id") int id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "view_ticket";
	}

	@GetMapping("/search")
	public String searchPost(@RequestParam("q") String query, Model model) {
		List<Ticket> tickets = this.ticketService.searchForTicket(query);
		model.addAttribute("tickets", tickets);
		return "/tickets";
	}

}
