package com.bff_agendador_tarefas.dto.tarefa.response;

import com.bff_agendador_tarefas.dto.tarefa.TarefaStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarefaResponseDTO {
    private String id;
    private String titulo;
    private String descricao;
    private TarefaStatus status;
    private LocalDateTime dataVencimento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
}


