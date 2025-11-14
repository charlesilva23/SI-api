package com.inova.siapi.modules.ticket.controller;

import com.inova.siapi.modules.ticket.dtos.TicketCreateDTO;
import com.inova.siapi.modules.ticket.dtos.TicketResponseDTO;
import com.inova.siapi.modules.ticket.entities.Ticket;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import com.inova.siapi.modules.ticket.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/tickets")

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @PostMapping
    public ResponseEntity<TicketResponseDTO> createTicket(@Valid @RequestBody TicketCreateDTO dto) {
        TicketResponseDTO created = ticketService.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> listTickets() {
        List<TicketResponseDTO> tickets = ticketService.listAll();
        return ResponseEntity.status(200).body(tickets);
    }

}
