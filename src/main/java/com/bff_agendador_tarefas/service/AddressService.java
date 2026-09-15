package com.bff_agendador_tarefas.service;

import com.bff_agendador_tarefas.client.UserClient;
import com.bff_agendador_tarefas.dto.address.AddressRequestDTO;
import com.bff_agendador_tarefas.dto.address.AddressResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final UserClient usuarioClient;

    public AddressResponseDTO criar(AddressRequestDTO request) {
        return usuarioClient.criarEndereco(request);
    }

    public AddressResponseDTO atualizar(Long id, AddressRequestDTO request) {
        return usuarioClient.atualizarEndereco(id, request);
    }

    public void excluir(Long id) {
        usuarioClient.excluirEndereco(id);
    }
}


