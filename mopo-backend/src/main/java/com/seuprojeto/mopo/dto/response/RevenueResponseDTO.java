package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.Revenue;

import java.util.List;
import java.util.UUID;

public record RevenueResponseDTO(
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

    public static RevenueResponseDTO fromEntity(Revenue revenue) {
        return new RevenueResponseDTO(
                revenue.getId(),
                revenue.getTitle(),
                revenue.getDescription(),
                revenue.getImage(),
                revenue.getIngredients(),
                revenue.getInstructions(),
                revenue.getPreparationTime(),
                revenue.getEfficiency(),
                revenue.getRating(),
                revenue.getDifficulty()
        );
    }
}
