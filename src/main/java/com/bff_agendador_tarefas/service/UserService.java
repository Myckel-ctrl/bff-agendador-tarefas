package com.bff_agendador_tarefas.service;


import com.bff_agendador_tarefas.client.UserClient;
import com.bff_agendador_tarefas.dto.user.request.UserUpdateRequestDTO;
import com.bff_agendador_tarefas.dto.user.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient userClient;

    public UserResponseDTO buscarPerfil() {
        return userClient.buscarPerfil();
    }

    public UserResponseDTO atualizarPerfil(UserUpdateRequestDTO request) {
        return userClient.atualizarPerfil(request);
    }

    public void excluirConta() {
        userClient.excluirConta();
    }

}



