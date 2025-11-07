package com.inova.siapi.modules.ticket.entities;
import com.inova.siapi.common.entities.BaseEntity;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ticket")

public class Ticket extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatusEnum status;

}
