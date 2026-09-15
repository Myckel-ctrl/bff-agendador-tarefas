package com.bff_agendador_tarefas.service;

import com.bff_agendador_tarefa.client.UserClient;
import com.bff_agendador_tarefa.dto.phone.PhoneRequestDTO;
import com.bff_agendador_tarefa.dto.phone.PhoneResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final UserClient usuarioClient;

    public PhoneResponseDTO criar(PhoneRequestDTO request) {
        return usuarioClient.criarTelefone(request);
    }

    public PhoneResponseDTO atualizar(Long id, PhoneRequestDTO request) {
        return usuarioClient.atualizarTelefone(id, request);
    }

    public void excluir(Long id) {
        usuarioClient.excluirTelefone(id);
    }

}


