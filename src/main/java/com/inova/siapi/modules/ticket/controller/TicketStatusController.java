package com.inova.siapi.modules.ticket.controller;

import com.inova.siapi.modules.ticket.entities.enums.TicketStatusEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tickets/status")
public class TicketStatusController {

    @GetMapping
    public List<?> getAllStatus() {
        return Arrays.stream(TicketStatusEnum.values())
                .map(s -> Map.of(
                        "id", s.getId(),
                        "code", s.name(),
                        "name", s.getName()
                ))
                .toList();
    }
}
