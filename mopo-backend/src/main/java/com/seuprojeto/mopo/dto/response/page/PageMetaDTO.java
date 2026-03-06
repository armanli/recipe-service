package com.seuprojeto.mopo.dto.response.page;

public record PageMetaDTO(
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean hasNext,
        boolean hasPrevious
) {
}
