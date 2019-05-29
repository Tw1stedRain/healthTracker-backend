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
    public void createExercise(
            @RequestBody Exercise exercise
    ) {
        repo.save(exercise);
    }

    @GetMapping("all")
    public List getAllExercises() {
        return repo.findAll();
    }


}
