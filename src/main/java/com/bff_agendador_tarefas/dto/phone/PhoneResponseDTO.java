package com.bff_agendador_tarefas.dto.phone;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneResponseDTO {
    private Long id;
    private String number;
    private PhoneType type;
}
