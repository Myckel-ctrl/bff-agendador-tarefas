package com.bff_agendador_tarefas.dto.user.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDTO {

    private String name;

    @Email(message = "Informe um e-mail válido.")
    private String email;

    private String password;
}
