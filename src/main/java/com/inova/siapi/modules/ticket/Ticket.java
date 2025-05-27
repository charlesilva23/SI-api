package com.inova.siapi.modules.ticket;
import com.inova.siapi.common.entities.BaseEntity;
import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket extends BaseEntity {

    @Column(nullable = false)
    private String Title;

    @Column(length = 2000)
    private String Description;

    @Column(nullable = false)
    private String Author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatusEnum Status;

}
