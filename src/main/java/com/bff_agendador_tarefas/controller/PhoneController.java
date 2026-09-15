package com.bff_agendador_tarefas.controller;

import com.bff_agendador_tarefas.dto.phone.PhoneRequestDTO;
import com.bff_agendador_tarefas.dto.phone.PhoneResponseDTO;
import com.bff_agendador_tarefas.service.PhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("phones")
@RequiredArgsConstructor
@Tag(name = "Telefone")
@SecurityRequirement(name = "bearerAuth")
public class PhoneController {

    private final PhoneService phoneService;

    @PostMapping
    @Operation(summary = "Cadastra um telefone para o usuário autenticado")
    public ResponseEntity<PhoneResponseDTO> createPhone(@Valid @RequestBody PhoneRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneService.criar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um telefone do usuário autenticado")
    public ResponseEntity<PhoneResponseDTO> updatePhone(@PathVariable Long id,
                                                   @Valid @RequestBody PhoneRequestDTO request) {
        return ResponseEntity.ok(phoneService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um telefone do usuário autenticado")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}


