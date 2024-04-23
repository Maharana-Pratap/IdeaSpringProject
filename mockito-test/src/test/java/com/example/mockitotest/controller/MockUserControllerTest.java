package com.example.mockitotest.controller;

import com.example.mockitotest.entity.MockUser;
import com.example.mockitotest.service.MockUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class MockUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MockUserService userService;

    private MockUser user;
    private List<MockUser> userList;

    @BeforeEach
    public void initilizeValue() {
        user = MockUser.builder()
                .name("maharana")
                .phone("9558949494")
                .email("test@email.com")
                .build();
        userList = List.of(
                user,
                MockUser.builder()
                        .name("pratap")
                        .phone("4543433534")
                        .email("pratap@email.com")
                        .build()
        );
    }

    @Test
    public void saveUser_test() throws Exception {
        when(userService.addUser(user)).thenReturn(user);
        mockMvc.perform(post("/mock/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateUser_test() throws Exception {
        when(userService.updateUser(user)).thenReturn(user);
        mockMvc.perform(put("/mock/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    public void userById_test() throws Exception {
        when(userService.userById(3)).thenReturn(user);
        mockMvc.perform(get("/mock/{id}",3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("maharana"));
    }

    @Test
    public void getAllUser_test() throws Exception {
        when(userService.getAllUser()).thenReturn(userList);
        mockMvc.perform(get("/mock/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].name").value("pratap"));
    }

}
