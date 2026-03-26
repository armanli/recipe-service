package com.mopo.recipe_service.service.interfaces;

import com.mopo.recipe_service.dto.request.ClientCreateRequestDTO;
import com.mopo.recipe_service.dto.response.ClientResponseDTO;
import com.mopo.recipe_service.dto.response.page.PageResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IClientService {
    PageResponseDTO<ClientResponseDTO> findAll(Pageable pageable, String baseUrl);

    ClientResponseDTO findById(UUID id);

    ClientResponseDTO create(ClientCreateRequestDTO request);

    void deleteById(UUID id);
}
