package com.mopo.recipe_service.service.interfaces;

import com.mopo.recipe_service.dto.request.CreateOrUpdateRecipeRequestDTO;
import com.mopo.recipe_service.dto.response.RecipeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IRecipeService {
    Page<RecipeResponseDTO> findAll(Pageable pageable);

    RecipeResponseDTO findById(UUID id);

    RecipeResponseDTO findByTitle(String title);

    RecipeResponseDTO create(CreateOrUpdateRecipeRequestDTO request);

    RecipeResponseDTO update(UUID id, CreateOrUpdateRecipeRequestDTO request);

    void delete(UUID id);
}

