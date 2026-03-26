package com.mopo.recipe_service.adapters.in.controller.recipe;

import com.mopo.recipe_service.application.ports.in.recipe.IRecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.mopo.recipe_service.adapters.in.controller.recipe.dtos.request.*;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
    private final IRecipeService service;

    public RecipesController(IRecipeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<?>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        var response = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateOrUpdateRecipeRequestDTO dto) {
        var response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody CreateOrUpdateRecipeRequestDTO dto) {
        var response = service.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
