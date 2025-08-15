package com.example.mockitotest.controller;

import com.example.mockitotest.entity.MockUser;
import com.example.mockitotest.service.MockUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class MockUserControllerTest {

    @Autowired
   // @Mock
    private MockMvc mockMvc;

    @InjectMocks
    private String abc = "";

    @MockBean // ===> for Spring-boot app (Controller/Service). It is just clone/mock the object only and inject at runtime also
    //@Mock //===> It is just clone/mock the object only but not to inject at runtime
    //@InjectMocks //===> Non springBoot app, will work on variable not on object
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

        // verify userService.addUser() is called or not.
        verify(userService).addUser(user);

        // verify how many times userService.addUser() is called.
        verify(userService,times(1)).addUser(user);
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

    @Test
    public void adduser_test() throws Exception {
        when(userService.addUser(user)).thenReturn(user);
        mockMvc.perform(post("/mock/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());
    }
}
