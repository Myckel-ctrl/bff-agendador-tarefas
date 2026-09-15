package com.bff_agendador_tarefas.client;

import com.bff_agendador_tarefa.dto.address.AddressRequestDTO;
import com.bff_agendador_tarefa.dto.address.AddressResponseDTO;
import com.bff_agendador_tarefa.dto.auth.AuthRequestDTO;
import com.bff_agendador_tarefa.dto.auth.AuthResponseDTO;
import com.bff_agendador_tarefa.dto.phone.PhoneRequestDTO;
import com.bff_agendador_tarefa.dto.phone.PhoneResponseDTO;
import com.bff_agendador_tarefa.dto.user.request.UserRequestDTO;
import com.bff_agendador_tarefa.dto.user.request.UserUpdateRequestDTO;
import com.bff_agendador_tarefa.dto.user.response.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UserClient {

    @PostMapping("/auth/login")
    AuthResponseDTO login(@RequestBody AuthRequestDTO request);

    @PostMapping("/auth/register")
    UserResponseDTO cadastrar(@RequestBody UserRequestDTO request);

    @GetMapping("/users/me")
    UserResponseDTO buscarPerfil();

    @PutMapping("/users/me")
    UserResponseDTO atualizarPerfil(@RequestBody UserUpdateRequestDTO request);

    @DeleteMapping("/users/me")
    void excluirConta();

    @PostMapping("/addresses")
    AddressResponseDTO criarEndereco(@RequestBody AddressRequestDTO request);

    @PutMapping("/addresses/{id}")
    AddressResponseDTO atualizarEndereco(@PathVariable("id") Long id, @RequestBody AddressRequestDTO request);

    @DeleteMapping("/addresses/{id}")
    void excluirEndereco(@PathVariable("id") Long id);

    @PostMapping("/phones")
    PhoneResponseDTO criarTelefone(@RequestBody PhoneRequestDTO request);

    @PutMapping("/phones/{id}")
    PhoneResponseDTO atualizarTelefone(@PathVariable("id") Long id, @RequestBody PhoneRequestDTO request);

    @DeleteMapping("/phones/{id}")
    void excluirTelefone(@PathVariable("id") Long id);

}


