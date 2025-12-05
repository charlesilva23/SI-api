package com.inova.siapi.modules.ticket.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketPatchDTO {
    private String title;
    private String description;
    private String author;
    private Integer statusId;

}
