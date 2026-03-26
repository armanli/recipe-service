package com.mopo.recipe_service.dto.response.page;

public record PageMetaDTO(
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean hasNext,
        boolean hasPrevious
) {
}
