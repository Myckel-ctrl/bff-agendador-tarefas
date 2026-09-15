package com.bff_agendador_tarefas.controller;

import com.bff_agendador_tarefas.dto.address.AddressRequestDTO;
import com.bff_agendador_tarefas.dto.address.AddressResponseDTO;
import com.bff_agendador_tarefas.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
@Tag(name = "Endereço")
@SecurityRequirement(name = "bearerAuth")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @Operation(summary = "Cadastra um endereço para o usuário autenticado")
    public ResponseEntity<AddressResponseDTO> createAddress(@Valid @RequestBody AddressRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.criar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um endereço do usuário autenticado")
    public ResponseEntity<AddressResponseDTO> updateAddress(@PathVariable Long id,
                                                     @Valid @RequestBody AddressRequestDTO request) {
        return ResponseEntity.ok(addressService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um endereço do usuário autenticado")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
