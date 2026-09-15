package com.bff_agendador_tarefas.controller;

import com.bff_agendador_tarefas.dto.auth.AuthRequestDTO;
import com.bff_agendador_tarefas.dto.auth.AuthResponseDTO;
import com.bff_agendador_tarefas.dto.user.request.UserRequestDTO;
import com.bff_agendador_tarefas.dto.user.response.UserResponseDTO;
import com.bff_agendador_tarefas.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
