package com.thoughtworks.nho.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.nho.domain.TrainingCamp;
import com.thoughtworks.nho.repository.TrainingCampRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TrainingCampControllerTest extends BaseControllerTest {
    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;


    @Autowired
    private TrainingCampRepository trainingCampRepository;

    @AfterEach
    void teardown() {
        trainingCampRepository.deleteAllInBatch();
    }


    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void should_find_all() throws Exception {
        mockMvc.perform(get("/api/training_camp/list"))
                .andExpect(status().isOk());

    }


//    @Test
//    void should_save_success() throws Exception {
//        TrainingCamp tr = TrainingCamp.builder().desc("dsadsa").title("dsamdlsajd").build();
//        mockMvc.perform(post("/api/training_camp/creat")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(tr)))
//                .andExpect(status().isCreated()).andExpect(content().string("success"));
//    }


    @Test
    void should_save_error() throws Exception {
        TrainingCamp tr = TrainingCamp.builder().desc("dsadsa").title("test").build();
        mockMvc.perform(post("/api/training_camp/creat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(tr)));

        mockMvc.perform(post("/api/training_camp/creat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(tr)))
                .andExpect(status().isCreated()).andExpect(content().string("error"));

    }

}