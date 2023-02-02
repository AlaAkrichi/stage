package com.cpj.stage.rest;


import com.cpj.stage.model.Exercice;
import com.cpj.stage.service.ExerciceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercice/")
public class ExerciceRestController {

    private final Logger log = LoggerFactory.getLogger(ExerciceRestController.class);

    private final ExerciceService exerciceService;

    public ExerciceRestController ( ExerciceService exerciceService ) {
        this.exerciceService = exerciceService;
    }

    @PostMapping("/create")
    public ResponseEntity < Exercice > createExercice( @RequestBody Exercice exercice) {
        log.info(exercice.toString());
//        log.info("REST request to save exercice : {}", exercice);
//        Exercice result = exerciceService.create(exercice);
        return ResponseEntity.ok(exercice);
    }

    @PutMapping("/update")
    public ResponseEntity<Exercice> updateExercice(@RequestBody Exercice exercice) {
        log.info("REST request to update exercice : {}", exercice);
        Exercice result = exerciceService.update(exercice);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Exercice> deleteExercice(@RequestBody Exercice exercice) {
        log.info("REST request to delete exercice : {}", exercice);
        exerciceService.delete(exercice);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/all")
    public ResponseEntity< List <Exercice> > getAllExercice( Pageable pageable) {
        final Page<Exercice> page = exerciceService.getAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }
    @GetMapping("/get/{code}")
    public ResponseEntity<Exercice> getExerciceByCode(@PathVariable Long code) {
        log.info("REST request to get flux with code : {}", code);
        Exercice result = exerciceService.getById(code);
        return ResponseEntity.ok(result);

    }
}