package com.inova.siapi.modules.ticket.controller;

import com.inova.siapi.modules.ticket.dtos.TicketCreateDTO;
import com.inova.siapi.modules.ticket.dtos.TicketResponseDTO;
import com.inova.siapi.modules.ticket.entities.Ticket;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import com.inova.siapi.modules.ticket.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


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

}
