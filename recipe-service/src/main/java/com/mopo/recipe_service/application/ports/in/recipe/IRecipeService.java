package com.mopo.recipe_service.application.ports.in.recipe;

import com.mopo.recipe_service.adapters.in.controller.recipe.dtos.request.CreateOrUpdateRecipeRequestDTO;
import com.mopo.recipe_service.adapters.in.controller.recipe.dtos.response.RecipeResponseDTO;
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

