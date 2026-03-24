package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.Revenue;

import java.util.Base64;
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
        String imageBase64 = null;
        if (revenue.getImage() != null) {
            imageBase64 = Base64.getEncoder().encodeToString(revenue.getImage());
        }
        return new RevenueResponseDTO(
                revenue.getId(),
                revenue.getTitle(),
                revenue.getDescription(),
                imageBase64,
                revenue.getIngredients(),
                revenue.getInstructions(),
                revenue.getPreparationTime(),
                revenue.getEfficiency(),
                revenue.getRating(),
                revenue.getDifficulty()
        );
    }
}
