package com.bff_agendador_tarefas.dto.user.response;

import com.bff_agendador_tarefa.dto.address.AddressResponseDTO;
import com.bff_agendador_tarefa.dto.phone.PhoneResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
    public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String role;
    private List<AddressResponseDTO> addresses;
    private List<PhoneResponseDTO> phones;
}



