package com.example.healthTrackerbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseRepo repo;

    @PostMapping("/")
    public Exercise createExercise(
            @RequestBody Exercise exercise
    ) {
        Exercise exercise1 = repo.save(exercise);
        return exercise1;
    }

    @GetMapping("/all")
    public List getAllExercises() {
        return repo.findAll();
    }


}
