package com.bff_agendador_tarefas.dto.tarefa.request;

import com.bff_agendador_tarefas.dto.tarefa.TarefaStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskStatusUpdateRequestDTO {

    @NotNull(message = "O status é obrigatório.")
    private TarefaStatus status;
}
