package com.seuprojeto.mopo.controller;

import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import com.seuprojeto.mopo.dto.response.page.PageResponseDTO;
import com.seuprojeto.mopo.dto.request.ClientCreateRequestDTO;
import com.seuprojeto.mopo.service.interfaces.IClientService;
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
@CrossOrigin(origins = "http://localhost:4200")
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
