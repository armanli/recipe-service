package com.seuprojeto.mopo.repository;

import com.seuprojeto.mopo.dto.response.RevenueResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.mopo.model.Revenue;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRevenueRepository extends JpaRepository<Revenue, UUID> {
    Page<Revenue> findAll(Pageable pageable);

    Optional<Revenue> findByTitle(String title);

    boolean existsByTitle(String title);
}
