package com.seuprojeto.mopo.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.UUID;

import com.seuprojeto.mopo.dto.response.RevenueResponseDTO;
import com.seuprojeto.mopo.service.interfaces.IRevenueService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.seuprojeto.mopo.dto.request.CreateOrUpdateRevenueRequestDTO;
import com.seuprojeto.mopo.model.Revenue;
import com.seuprojeto.mopo.repository.IRevenueRepository;

@Service
public class RevenueService implements IRevenueService {
    private final IRevenueRepository repository;

    public RevenueService(IRevenueRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<RevenueResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(RevenueResponseDTO::fromEntity);
    }

    @Override
    public RevenueResponseDTO findById(UUID id) {
        return repository.findById(id).map(RevenueResponseDTO::fromEntity).orElseThrow();
    }

    @Override
    public RevenueResponseDTO findByTitle(String title) {
        return repository.findByTitle(title).map(RevenueResponseDTO::fromEntity).orElseThrow();
    }

    @Override
    public RevenueResponseDTO create(CreateOrUpdateRevenueRequestDTO dto) {
        if (repository.existsByTitle(dto.title()))
            throw new EntityExistsException("Title already exists");

        var entity = buildRevenueFromDTO(dto);

        var response = repository.save(entity);
        return RevenueResponseDTO.fromEntity(response);
    }

    @Override
    public RevenueResponseDTO update(UUID id, CreateOrUpdateRevenueRequestDTO dto) {
        var responseDTO = findById(id);

        var entity = buildRevenueFromDTO(responseDTO);
        BeanUtils.copyProperties(dto, entity);
        var response = repository.save(entity);

        return RevenueResponseDTO.fromEntity(response);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresentOrElse(repository::delete,
                () -> {
                    throw new EntityNotFoundException("Revenue not found");
                });
    }

    private Revenue buildRevenueFromDTO(RevenueResponseDTO dto) {
        return Revenue.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .image(Base64.getDecoder().decode(dto.image()))
                .ingredients(dto.ingredients() != null ? new ArrayList<>(dto.ingredients()) : new ArrayList<>())
                .instructions(dto.instructions() != null ? new ArrayList<>(dto.instructions()) : new ArrayList<>())
                .preparationTime(dto.preparationTime())
                .efficiency(dto.efficiency())
                .rating(dto.rating())
                .difficulty(dto.difficulty())
                .build();
    }

    private Revenue buildRevenueFromDTO(CreateOrUpdateRevenueRequestDTO dto) {
        return Revenue.builder()
                .title(dto.title())
                .image(Base64.getDecoder().decode(dto.image()))
                .ingredients(dto.ingredients() != null ? dto.ingredients() : new ArrayList<>())
                .instructions(dto.instructions() != null ? dto.instructions() : new ArrayList<>())
                .preparationTime(dto.preparationTimeInMinutes())
                .efficiency(dto.efficiency())
                .rating(dto.rating())
                .difficulty(dto.difficulty())
                .build();
    }
}
