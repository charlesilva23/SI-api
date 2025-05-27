package com.inova.siapi.modules.ticket.dtos;

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
    private TicketStatusEnum status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
