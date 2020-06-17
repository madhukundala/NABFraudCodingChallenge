package com.nab.finance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nab.finance.DTO.GameDTO;
import com.nab.finance.domain.Game;
import com.nab.finance.domain.Player;
import com.nab.finance.repository.GameRepository;
import com.nab.finance.service.GameService;
import com.nab.finance.util.JsonUtil;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.xml.bind.DatatypeConverter;

import static org.junit.Assert.assertEquals;

/**
 * Created by madhu on 15.06.20.
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GameRestControllerTest {

    @MockBean
    GameService gameService;

    @MockBean
    GameRepository gameRepository;

   /* @Autowired
    private MockMvc mockMvc;*/

   /* @Autowired
    private TestRestTemplate template;*/

    // @Test
    // @WithUserDetails()
    public void createGameTest() throws Exception {

        String gameResponse = JsonUtil.readJsonFile("/outputs/game/createGameResponse.json");

        Game gameObject = JsonUtil.getObjectFromJson(gameResponse, Game.class);
        Mockito.when(gameService.createNewGame(Mockito.any(Player.class), Mockito.any(GameDTO.class))).thenReturn(gameObject);
        String requestBody = new ObjectMapper().valueToTree(new GameDTO()).toString();

        String authorizationHeader = "Basic " + DatatypeConverter.printBase64Binary(("test" + ":" + "test").getBytes());

        HttpEntity<String> request =
                new HttpEntity<String>(gameObject.toString());
        TestRestTemplate template
                = new TestRestTemplate("user", "passwd");

        ResponseEntity<Game> result = template.withBasicAuth("test", "test")
                .postForEntity("http://localhost:9090/v1/nab/api/game/createGame", new GameDTO(), Game.class);

        assertEquals(HttpStatus.OK, result.getStatusCode());


      /*  this.mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/nab/api/game/createGame")
                .header(HttpHeaders.AUTHORIZATION,authorizationHeader)
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());*/

    }
}
