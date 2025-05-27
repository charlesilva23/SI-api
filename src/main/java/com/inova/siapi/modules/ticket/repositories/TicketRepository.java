package com.inova.siapi.modules.ticket.repositories;

import com.inova.siapi.modules.ticket.Ticket;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByTitle(String title);

    List<Ticket> findByAuthor(String author);

    List<Ticket> findByStatus(TicketStatusEnum status);

    List<Ticket> findByCreatedAtAfter(LocalDateTime date);

    List<Ticket> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);


}
