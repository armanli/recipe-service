package com.seuprojeto.mopo.service;

import com.seuprojeto.mopo.dto.request.ClientCreateRequestDTO;
import com.seuprojeto.mopo.dto.response.ClientResponseDTO;
import com.seuprojeto.mopo.dto.response.page.PageResponseDTO;
import com.seuprojeto.mopo.exceptions.ResourceNotFoundException;
import com.seuprojeto.mopo.model.Client;
import com.seuprojeto.mopo.repository.IClientRepository;
import com.seuprojeto.mopo.service.interfaces.IClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService implements IClientService {

    private final IClientRepository repository;

    public ClientService(IClientRepository repository) {
        this.repository = repository;
    }

    public PageResponseDTO<ClientResponseDTO> findAll(Pageable pageable, String baseUrl) {
        var pages = repository.findAll(pageable);
        var pagesMapped = pages.map(ClientResponseDTO::fromEntity);

        return PageResponseDTO.fromPage(pagesMapped, baseUrl);
    }

    public ClientResponseDTO findById(UUID id) {
        return repository.findById(id)
                .map(ClientResponseDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException(Client.class.toString(), "id", id));
    }

    public ClientResponseDTO create(ClientCreateRequestDTO dto) {
        repository.findByEmail(dto.email()).ifPresent(res -> {
            throw new IllegalArgumentException(String.format("Client with email %s already exists", dto.email()));
        });

        var entity = Client.builder().username(dto.username()).email(dto.email()).password(dto.password()).build();
        var response = repository.save(entity);

        return ClientResponseDTO.fromEntity(response);
    }

    public void deleteById(UUID id) {
        findById(id);
        repository.deleteById(id);
    }
}