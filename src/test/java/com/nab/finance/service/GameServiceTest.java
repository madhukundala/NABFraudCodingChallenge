package com.nab.finance.service;

import com.nab.finance.domain.Game;
import com.nab.finance.domain.Player;
import com.nab.finance.repository.GameRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

/**
 * Created by madhu on 15.06.20.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GameServiceTest {

    @Autowired
    private IGameService gameService;

    @MockBean
    private GameRepository gameRepository;


    @Test
    public void getGameTest() {
        Game game = new Game();

        game.setCreated(new Date());
        game.setFirstPlayer(new Player());
        game.setGameId(Long.valueOf(3));
        Optional<Game> gameObj = Optional.of(game);

        Mockito.when(gameRepository.findById(Mockito.anyLong())).thenReturn(gameObj);

        Game gameResponse = gameService.getGame(Long.valueOf(3));
        Assert.assertNotNull(gameResponse);

    }


}
