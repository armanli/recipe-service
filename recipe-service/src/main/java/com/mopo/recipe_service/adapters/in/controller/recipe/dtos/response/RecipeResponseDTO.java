package com.mopo.recipe_service.adapters.in.controller.recipe.dtos.response;

import com.mopo.recipe_service.application.domain.Recipe;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

public record RecipeResponseDTO(
        UUID id,
        String title,
        String description,
        String image,
        List<String> ingredients,
        List<String> instructions,
        int preparationTime,
        int efficiency,
        int rating,
        int difficulty
) {

    public static RecipeResponseDTO fromEntity(Recipe recipe) {
        String imageBase64 = null;
        if (recipe.getImage() != null) {
            imageBase64 = Base64.getEncoder().encodeToString(recipe.getImage());
        }
        return new RecipeResponseDTO(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getDescription(),
                imageBase64,
                recipe.getIngredients(),
                recipe.getInstructions(),
                recipe.getPreparationTime(),
                recipe.getEfficiency(),
                recipe.getRating(),
                recipe.getDifficulty()
        );
    }
}
