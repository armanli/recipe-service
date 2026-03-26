package com.mopo.recipe_service.controller;

import com.mopo.recipe_service.dto.request.ClientCreateRequestDTO;
import com.mopo.recipe_service.dto.response.ClientResponseDTO;
import com.mopo.recipe_service.dto.response.page.PageResponseDTO;
import com.mopo.recipe_service.service.interfaces.IClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final IClientService service;

    public ClientController(IClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<PageResponseDTO<ClientResponseDTO>> findAll(
            @ParameterObject
            @PageableDefault(size = 20, direction = Sort.Direction.ASC) Pageable pageable,
            HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll(pageable, request.getRequestURL().toString()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientCreateRequestDTO client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
