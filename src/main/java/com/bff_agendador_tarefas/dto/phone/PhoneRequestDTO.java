package com.bff_agendador_tarefas.dto.phone;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequestDTO {

    private String number;

    @NotNull(message = "O tipo do telefone é obrigatório.")
    private PhoneType type;
}


