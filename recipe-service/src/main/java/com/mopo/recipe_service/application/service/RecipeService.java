package com.mopo.recipe_service.application.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.UUID;

import com.mopo.recipe_service.adapters.in.controller.recipe.dtos.request.CreateOrUpdateRecipeRequestDTO;
import com.mopo.recipe_service.adapters.in.controller.recipe.dtos.response.RecipeResponseDTO;
import com.mopo.recipe_service.application.domain.Recipe;
import com.mopo.recipe_service.adapters.out.persistence.repository.IRecipeRepository;
import com.mopo.recipe_service.application.ports.in.recipe.IRecipeService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecipeService implements IRecipeService {
    private final IRecipeRepository repository;

    public RecipeService(IRecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<RecipeResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(RecipeResponseDTO::fromEntity);
    }

    @Override
    public RecipeResponseDTO findById(UUID id) {
        return repository.findById(id).map(RecipeResponseDTO::fromEntity).orElseThrow();
    }

    @Override
    public RecipeResponseDTO findByTitle(String title) {
        return repository.findByTitle(title).map(RecipeResponseDTO::fromEntity).orElseThrow();
    }

    @Override
    public RecipeResponseDTO create(CreateOrUpdateRecipeRequestDTO dto) {
        if (repository.existsByTitle(dto.title()))
            throw new EntityExistsException("Title already exists");

        var entity = buildRecipeFromDTO(dto);

        var response = repository.save(entity);
        return RecipeResponseDTO.fromEntity(response);
    }

    @Override
    public RecipeResponseDTO update(UUID id, CreateOrUpdateRecipeRequestDTO dto) {
        var responseDTO = findById(id);

        var entity = buildRecipeFromDTO(responseDTO);
        BeanUtils.copyProperties(dto, entity);
        var response = repository.save(entity);

        return RecipeResponseDTO.fromEntity(response);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresentOrElse(repository::delete,
                () -> {
                    throw new EntityNotFoundException("Recipe not found");
                });
    }

    private Recipe buildRecipeFromDTO(RecipeResponseDTO dto) {
        return Recipe.builder()
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

    private Recipe buildRecipeFromDTO(CreateOrUpdateRecipeRequestDTO dto) {
        return Recipe.builder()
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
