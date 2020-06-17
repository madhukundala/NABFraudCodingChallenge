package com.nab.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by madhu on 15.06.20.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class GameServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    private String validResponsePath = "/response.json";

}
