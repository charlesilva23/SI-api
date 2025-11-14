package com.inova.siapi.modules.ticket.dtos;

import com.inova.siapi.modules.ticket.entities.Ticket;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponseDTO {

    private Integer id;
    private String title;
    private String description;
    private String author;

    private Integer statusId;
    private String statusName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TicketResponseDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.title = ticket.getTitle();
        this.description = ticket.getDescription();
        this.author = ticket.getAuthor();

        this.statusId = ticket.getStatus().getId();
        this.statusName = ticket.getStatus().getName();

        this.createdAt = ticket.getCreatedAt();
        this.updatedAt = ticket.getUpdatedAt();
    }
}
