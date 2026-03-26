package com.mopo.recipe_service.repository;

import com.mopo.recipe_service.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, UUID> {
    Page<Recipe> findAll(Pageable pageable);

    Optional<Recipe> findByTitle(String title);

    boolean existsByTitle(String title);
}
