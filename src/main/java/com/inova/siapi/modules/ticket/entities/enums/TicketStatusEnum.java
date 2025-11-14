package com.inova.siapi.modules.ticket.entities.enums;


import com.inova.siapi.modules.enums.entities.interfaces.EnumInterface;
import lombok.Getter;

@Getter
public enum TicketStatusEnum implements EnumInterface {
    OPEN(1, "ABERTO"),
    IN_PROGRESS(2, "EM PROGRESSO"),
    RESOLVED(3, "RESOLVIDO");

    private final Integer id;
    private final String name;


    TicketStatusEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TicketStatusEnum fromId(Integer id) {
        for (TicketStatusEnum type : TicketStatusEnum.values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid id: " + id);
    }

}
