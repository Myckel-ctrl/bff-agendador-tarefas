package com.bff_agendador_tarefas.controller;

import com.bff_agendador_tarefa.dto.tarefa.request.TarefaRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.request.TarefaUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.request.TaskStatusUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.tarefa.response.TarefaResponseDTO;
import com.bff_agendador_tarefa.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas")
@SecurityRequirement(name = "bearerAuth")
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    @Operation(summary = "Cria uma tarefa para o usuário autenticado")
    public ResponseEntity<TarefaResponseDTO> createTarefa(@Valid @RequestBody TarefaRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criar(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma tarefa pelo ID")
    public ResponseEntity<TarefaResponseDTO> getTarefaById(@PathVariable String id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Lista as tarefas do usuário autenticado")
    public ResponseEntity<List<TarefaResponseDTO>> listTarefa() {
        return ResponseEntity.ok(tarefaService.listar());
    }

    @GetMapping("/periodo")
    @Operation(summary = "Busca tarefas por período (data de vencimento)")
    public ResponseEntity<List<TarefaResponseDTO>> searchTarefaByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(tarefaService.buscarPorPeriodo(startDate, endDate));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualiza parcialmente uma tarefa")
    public ResponseEntity<TarefaResponseDTO> updateTarefa(@PathVariable String id,
                                                          @Valid @RequestBody TarefaUpdateRequestDTO request) {
        return ResponseEntity.ok(tarefaService.atualizar(id, request));
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Altera apenas o status de uma tarefa")
    public ResponseEntity<TarefaResponseDTO> updateTarefaStatus(@PathVariable String id,
                                                                @Valid @RequestBody TaskStatusUpdateRequestDTO request) {
        return ResponseEntity.ok(tarefaService.atualizarStatus(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma tarefa")
    public ResponseEntity<Void> deleteTarefa(@PathVariable String id) {
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}


