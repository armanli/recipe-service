package com.seuprojeto.mopo.service.interfaces;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.dto.response.RevenueResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IRevenueService {
    Page<RevenueResponseDTO> findAll(Pageable pageable);

    RevenueResponseDTO findById(UUID id);

    RevenueResponseDTO findByTitle(String title);

    RevenueResponseDTO create(CreateOrUpdateRevenueRequestDTO request);

    RevenueResponseDTO update(UUID id, CreateOrUpdateRevenueRequestDTO request);

    void delete(UUID id);
}

