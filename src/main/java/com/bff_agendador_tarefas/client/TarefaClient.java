package com.bff_agendador_tarefas.client;

import com.bff_agendador_tarefa.dto.tarefa.request.TarefaRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.request.TarefaUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.request.TaskStatusUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.response.TarefaResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefaClient {

    @PostMapping("/tarefas")
    TarefaResponseDTO criar(@RequestBody TarefaRequestDTO request);

    @GetMapping("/tarefas/{id}")
    TarefaResponseDTO buscarPorId(@PathVariable("id") String id);

    @GetMapping("/tarefas")
    List<TarefaResponseDTO> listar();

    @GetMapping("/tarefas/periodo")
    List<TarefaResponseDTO> buscarPorPeriodo(@RequestParam("inicio") String inicio,
                                             @RequestParam("fim") String fim);

    @PatchMapping("/tarefas/{id}")
    TarefaResponseDTO atualizar(@PathVariable("id") String id, @RequestBody TarefaUpdateRequestDTO request);

    @PatchMapping("/tarefas/{id}/status")
    TarefaResponseDTO atualizarStatus(@PathVariable("id") String id, @RequestBody TaskStatusUpdateRequestDTO request);

    @DeleteMapping("/tarefas/{id}")
    void excluir(@PathVariable("id") String id);
}
