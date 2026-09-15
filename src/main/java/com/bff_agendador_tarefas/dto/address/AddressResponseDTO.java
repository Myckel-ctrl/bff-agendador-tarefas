package com.bff_agendador_tarefas.dto.address;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponseDTO {
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String zipcode;
}


