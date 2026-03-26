package com.mopo.recipe_service.dto.response.page;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponseDTO<T>(
        List<T> data,
        PageMetaDTO meta,
        PageLinksDTO links
) {

    public static <T> PageResponseDTO<T> fromPage(Page<T> page, String baseUrl) {

        var meta = new PageMetaDTO(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.hasNext(),
                page.hasPrevious()
        );

        String next = page.hasNext()
                ? baseUrl + "?page=" + (page.getNumber() + 1) + "&size=" + page.getSize()
                : null;

        String previous = page.hasPrevious()
                ? baseUrl + "?page=" + (page.getNumber() - 1) + "&size=" + page.getSize()
                : null;

        var links = new PageLinksDTO(next, previous);

        return new PageResponseDTO<>(
                page.getContent(),
                meta,
                links
        );
    }
}