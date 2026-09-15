package com.bff_agendador_tarefas.service;

import com.bff_agendador_tarefa.client.TarefaClient;
import com.bff_agendador_tarefa.dto.tarefa.request.TarefaRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.request.TarefaUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.request.TaskStatusUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.response.TarefaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaClient tarefaClient;

    public TarefaResponseDTO criar(TarefaRequestDTO request) {
        return tarefaClient.criar(request);
    }

    public TarefaResponseDTO buscarPorId(String id) {
        return tarefaClient.buscarPorId(id);
    }

    public List<TarefaResponseDTO> listar() {
        return tarefaClient.listar();
    }

    public List<TarefaResponseDTO> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return tarefaClient.buscarPorPeriodo(inicio.toString(), fim.toString());
    }

    public TarefaResponseDTO atualizar(String id, TarefaUpdateRequestDTO request) {
        return tarefaClient.atualizar(id, request);
    }

    public TarefaResponseDTO atualizarStatus(String id, TaskStatusUpdateRequestDTO request) {
        return tarefaClient.atualizarStatus(id, request);
    }

    public void excluir(String id) {
        tarefaClient.excluir(id);
    }

}

