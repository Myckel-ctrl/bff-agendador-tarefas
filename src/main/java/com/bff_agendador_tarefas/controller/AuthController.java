package com.bff_agendador_tarefas.controller;

import com.bff_agendador_tarefa.dto.auth.AuthRequestDTO;
import com.bff_agendador_tarefa.dto.auth.AuthResponseDTO;
import com.bff_agendador_tarefa.dto.user.request.UserRequestDTO;
import com.bff_agendador_tarefa.dto.user.response.UserResponseDTO;
import com.bff_agendador_tarefa.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Autenticação")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Cadastra um usuário (endpoint público, não exige JWT)")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    @Operation(summary = "Login (endpoint público, não exige JWT)")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
