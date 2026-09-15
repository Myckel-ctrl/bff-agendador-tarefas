package com.bff_agendador_tarefas.exception;

import lombok.Getter;

@Getter
public class FeignClientException extends RuntimeException {
    private final int status;

    public FeignClientException(int status, String message) {
        super(message);
        this.status = status;
    }
}

