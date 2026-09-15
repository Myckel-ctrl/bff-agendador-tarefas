package com.bff_agendador_tarefas.controller;

import com.bff_agendador_tarefa.dto.user.request.UserUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.user.response.UserResponseDTO;
import com.bff_agendador_tarefa.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Tag(name = "Usuário")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Retorna o perfil do usuário autenticado")
    public ResponseEntity<UserResponseDTO> findUser() {
        return ResponseEntity.ok(userService.buscarPerfil());
    }

    @PutMapping("/me")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Atualiza os dados do usuário autenticado")
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserUpdateRequestDTO request) {
        return ResponseEntity.ok(userService.atualizarPerfil(request));
    }

    @DeleteMapping("/me")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Exclui a conta do usuário autenticado")
    public ResponseEntity<Void> deleteUser() {
        userService.excluirConta();
        return ResponseEntity.noContent().build();
    }
}


