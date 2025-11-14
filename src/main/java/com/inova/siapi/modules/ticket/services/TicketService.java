package com.inova.siapi.modules.ticket.services;

import com.inova.siapi.modules.ticket.entities.Ticket;
import com.inova.siapi.modules.ticket.dtos.TicketCreateDTO;
import com.inova.siapi.modules.ticket.dtos.TicketResponseDTO;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import com.inova.siapi.modules.ticket.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<TicketResponseDTO> findAll() {
        return ticketRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public TicketResponseDTO findById(Integer id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado"));
        return toResponse(ticket);
    }

    public List<TicketResponseDTO> findByTitle(String title) {
        return ticketRepository.findByTitle(title)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public  List<TicketResponseDTO> findByTicket(TicketStatusEnum status) {
        return ticketRepository.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<TicketResponseDTO> findByAuthor(String author) {
        return ticketRepository.findByAuthor(author)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<TicketResponseDTO> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return ticketRepository.findByCreatedAtBetween(start, end)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public TicketResponseDTO create(TicketCreateDTO dto) {
        Ticket ticket = Ticket.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .author(dto.getAuthor())
                .status(TicketStatusEnum.fromId(dto.getStatusId()))
                .build();
        
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());

                return toResponse(ticketRepository.save(ticket));

    }

    @Transactional
    public TicketResponseDTO update(Integer id, TicketCreateDTO dto) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado"));

        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setAuthor(dto.getAuthor());
        ticket.setStatus(TicketStatusEnum.fromId(dto.getStatusId()));
        ticket.setUpdatedAt(LocalDateTime.now());

        return toResponse(ticketRepository.save(ticket));
    }

    public void delete(Integer id) {
        if(!ticketRepository.existsById(id)) {
            throw new RuntimeException("Ticket nao encontrado");
        }
        ticketRepository.deleteById(id);
    }

    public TicketResponseDTO toResponse(Ticket ticket) {
        return TicketResponseDTO.builder()
                .id(ticket.getId())
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .author(ticket.getAuthor())
                .statusId(ticket.getStatus().getId())
                .createdAt(ticket.getCreatedAt())
                .updatedAt(ticket.getUpdatedAt())
                .build();
    }

    public List<TicketResponseDTO> listAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(TicketResponseDTO::new)
                .toList();
    }
}
