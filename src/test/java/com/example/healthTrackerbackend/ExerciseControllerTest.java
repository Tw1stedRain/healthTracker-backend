package com.example.healthTrackerbackend;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ExerciseControllerTest {

    private MockMvc mockMvc;

    @Autowired
    ExerciseRepo repo;

    @Autowired
    public WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createNewRoute() throws Exception {

        Exercise exercise = new Exercise();
        exercise.setTitle("click");
        exercise.setQuantity("3");
        exercise.setDescription("taptaptap");
        exercise.setTimeStamp("ugh");

        Gson gson = new Gson();
        String data = gson.toJson(exercise);

        mockMvc.perform(MockMvcRequestBuilders.post("/exercise/")
                .contentType("application/json")
                .content(data)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void getAllRoute() throws Exception {

        Exercise exercise = new Exercise();
        exercise.setTitle("click");
        exercise.setQuantity("3");
        exercise.setDescription("taptaptap");
        exercise.setTimeStamp("ugh");

        repo.save(exercise);



        mockMvc.perform(MockMvcRequestBuilders.get("/exercise/all"))
                .andExpect(status().isOk());
    }

}