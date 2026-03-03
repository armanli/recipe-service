package com.seuprojeto.mopo.service.interfaces;

import com.seuprojeto.mopo.dto.request.ClientRequestDTO;
import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IClientService {
    Page<ClientResponseDTO> findAll(Pageable pageable);

    ClientResponseDTO findById(UUID id);

    ClientResponseDTO create(ClientRequestDTO request);

    ClientResponseDTO update(UUID id, ClientRequestDTO request);

    void deleteById(UUID id);
}
