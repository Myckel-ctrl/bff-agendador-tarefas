package com.bff_agendador_tarefas.service;


import com.bff_agendador_tarefas.client.UserClient;
import com.bff_agendador_tarefas.dto.auth.AuthRequestDTO;
import com.bff_agendador_tarefas.dto.auth.AuthResponseDTO;
import com.bff_agendador_tarefas.dto.user.request.UserRequestDTO;
import com.bff_agendador_tarefas.dto.user.response.UserResponseDTO;
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


