package com.inova.siapi.modules.ticket.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TicketCreateDTO {
    private Integer id;

    @NotBlank(message = "Título obrigatório")
    @Size(max = 100, message = "O Título deve ter no máximo 100 caracteres")
    private String title;

    @Size(max = 2000, message = "A descrição deve conter no máximo 2000 caracteres")
    private String description;

    @NotBlank(message = "Autor obrigatório")
    private String author;

    @NotNull(message = "Status obrigatório")
    private Integer statusId;

}

