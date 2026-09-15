package com.bff_agendador_tarefas.service;

import com.bff_agendador_tarefa.client.UserClient;
import com.bff_agendador_tarefa.dto.auth.AuthRequestDTO;
import com.bff_agendador_tarefa.dto.auth.AuthResponseDTO;
import com.bff_agendador_tarefa.dto.user.request.UserRequestDTO;
import com.bff_agendador_tarefa.dto.user.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserClient usuarioClient;

    public AuthResponseDTO login(AuthRequestDTO request) {
        return usuarioClient.login(request);
    }

    public UserResponseDTO register(UserRequestDTO request) {
        return usuarioClient.cadastrar(request);
    }
}


