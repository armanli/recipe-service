package com.seuprojeto.mopo.service.interfaces;

import com.seuprojeto.mopo.dto.request.ClientCreateRequestDTO;
import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import com.seuprojeto.mopo.dto.response.page.PageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IClientService {
    PageResponseDTO<ClientResponseDTO> findAll(Pageable pageable, String baseUrl);

    ClientResponseDTO findById(UUID id);

    ClientResponseDTO create(ClientCreateRequestDTO request);

    void deleteById(UUID id);
}
