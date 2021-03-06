package com.thoughtworks.nho.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.nho.cofiguration.security.LoginRequestUser;
import com.thoughtworks.nho.domain.User;
import com.thoughtworks.nho.repository.UserRepository;
import com.thoughtworks.nho.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthenticationControllerTest extends BaseControllerTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    @BeforeEach
    void setup() {
        super.setup();
        userService.create(User.builder().name("testUser").password("123").build());
    }

    @AfterEach
    void teardown(){
        userRepository.deleteAllInBatch();
    }

    @Test
    void should_login_successfully() throws Exception {
        LoginRequestUser loginRequestBody = LoginRequestUser.builder()
                .username("testUser").password("123").build();

        mockMvc.perform(post("/api/authentication")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(loginRequestBody)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testUser"));
    }

    @Test
    void should_login_failed_when_login_with_bad_credential() throws Exception {
        LoginRequestUser loginRequestBody = LoginRequestUser.builder()
                .username("wrong_username").password("wrong_password").build();

        mockMvc.perform(post("/api/authentication")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(loginRequestBody)))
                .andExpect(status().isUnauthorized());
    }

}