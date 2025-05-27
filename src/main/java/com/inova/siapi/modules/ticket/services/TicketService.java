package com.inova.siapi.modules.ticket.services;

import com.inova.siapi.modules.ticket.Ticket;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import com.inova.siapi.modules.ticket.repositories.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Integer id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> findByTitle(String title) {
        return ticketRepository.findByTitle(title);
    }

    public List<Ticket> findByTicket(TicketStatusEnum status) {
        return ticketRepository.findByStatus(status);
    }

    public List<Ticket> findByAuthor(String author) {
        return ticketRepository.findByAuthor(author);
    }

    public List<Ticket> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return ticketRepository.findByCreatedAtBetween(start, end);
    }

    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket update(Integer id, Ticket updatedTicket) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket nao encontrado"));

        ticket.setTitle(updatedTicket.getTitle());
        ticket.setDescription(updatedTicket.getDescription());
        ticket.setStatus(updatedTicket.getStatus());
        ticket.setAuthor(updatedTicket.getAuthor());

        return ticketRepository.save(ticket);
    }
}
