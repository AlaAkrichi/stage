package com.cpj.stage.service;


import com.cpj.stage.model.Exercice;
import com.cpj.stage.repository.ExerciceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ExerciceService {

    private final ExerciceRepository exerciceRepository;

    public ExerciceService ( ExerciceRepository exerciceRepository ) {
        this.exerciceRepository = exerciceRepository;
    }

    public Exercice create( Exercice exercice) {
        return exerciceRepository.save(exercice);
    }

    public Exercice update(Exercice exercice) {
        if (exerciceRepository.existsById(exercice.getId())) {
            return exerciceRepository.save(exercice);
        }
        return null;
    }

    public void delete(Exercice exercice) {
        exerciceRepository.deleteById(exercice.getId());
    }


    public Exercice getById( Long id) {
        return exerciceRepository.findById(id).orElse(null);
    }


    public Page <Exercice> getAll( Pageable pageable) {
        return exerciceRepository.findAll(pageable);
    }
}