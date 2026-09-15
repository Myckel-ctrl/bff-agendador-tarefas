package com.bff_agendador_tarefas.config;

import com.bff_agendador_tarefas.exception.FeignClientException;
import com.bff_agendador_tarefas.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = extractMessage(response);

        if (response.status() == 404) {
            return new ResourceNotFoundException(message);
        }
        return new FeignClientException(response.status(), message);
    }

    private String extractMessage(Response response) {
        if (response.body() == null) {
            return defaultMessage(response.status());
        }
        try (InputStream body = response.body().asInputStream()) {
            JsonNode json = objectMapper.readTree(body);
            if (json != null && json.has("message")) {
                return json.get("message").asText();
            }
        } catch (Exception ignored) {
        }
        return defaultMessage(response.status());
    }

    private String defaultMessage(int status) {
        return "Erro ao comunicar com o microsserviço (HTTP " + status + ").";
    }
}