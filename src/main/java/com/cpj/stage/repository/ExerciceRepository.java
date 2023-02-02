package com.cpj.stage.repository;


import com.cpj.stage.model.Exercice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciceRepository extends JpaRepository <Exercice, Long > {
    Optional <Exercice> findById (Long id );

    Exercice save ( Exercice exercice );

    void deleteById ( Long id );

    Page < Exercice > findAll ( Pageable pageable );
}
