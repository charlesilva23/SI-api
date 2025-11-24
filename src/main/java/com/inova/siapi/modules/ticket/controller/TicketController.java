package com.inova.siapi.modules.ticket.controller;

import com.inova.siapi.modules.ticket.dtos.TicketCreateDTO;
import com.inova.siapi.modules.ticket.dtos.TicketResponseDTO;
import com.inova.siapi.modules.ticket.entities.Ticket;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import com.inova.siapi.modules.ticket.repositories.TicketRepository;
import com.inova.siapi.modules.ticket.services.TicketService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/tickets")

public class TicketController {

    private final TicketService ticketService;
    private final TicketRepository ticketRepository;

    public TicketController(TicketService ticketService, TicketRepository ticketRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
    }


    @PostMapping
    public ResponseEntity<TicketResponseDTO> createTicket(@Valid @RequestBody TicketCreateDTO dto) {
        TicketResponseDTO created = ticketService.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> listTickets() {
        List<Ticket> tickets = ticketRepository.findAll(Sort.by("id"));
        return ResponseEntity.ok(
                tickets.stream().map(TicketResponseDTO::new).toList()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> updateTicket(
            @PathVariable Integer id,
            @Valid @RequestBody TicketCreateDTO dto
    ) {
        TicketResponseDTO updated = ticketService.update(id, dto);
        return ResponseEntity.status(201).body(updated);
    }

}
