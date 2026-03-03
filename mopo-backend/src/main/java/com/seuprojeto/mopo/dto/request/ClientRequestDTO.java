package com.seuprojeto.mopo.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ClientRequestDTO(
        @NotBlank(message = "The username cannot be empty.")
        String username,

        @Email(message = "The email address must be valid.")
        @NotBlank(message = "Email is required.")
        String email,

        @NotBlank(message = "A password is required.")
        @Size(min = 6, message = "The password must be at least 6 characters long.")
        String password,

        @NotBlank(message = "CPF is required.")
        @Size(min = 11, max = 11, message = "CPF must have 11 digits.")
        String cpf,

        @NotNull(message = "Date of birth is required.")
        @Past(message = "Invalid date of birth")
        LocalDate birthday
) {
}