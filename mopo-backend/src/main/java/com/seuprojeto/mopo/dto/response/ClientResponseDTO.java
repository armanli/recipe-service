package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.Client;

import java.util.UUID;

public record ClientResponseDTO(UUID id, String username, String email, String telephone) {
    public static ClientResponseDTO fromEntity(Client entity) {
        return new ClientResponseDTO(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getTelephone()
        );
    }
}
