package com.seuprojeto.mopo.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record ClientRequestDTO(
        @NotBlank(message = "Username não pode estar vazio") String username,

        @Email(message = "Email deve ser válido") @NotBlank(message = "Email é obrigatório") String email,

        @NotBlank(message = "Senha é obrigatória") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres") String password,

        @NotBlank(message = "CPF é obrigatório") @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos") String cpf,

        @NotNull(message = "Data de nascimento é obrigatória") @Past(message = "Data de nascimento inválida") LocalDate birthday) {
}