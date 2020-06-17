package com.nab.finance.service;

import com.nab.finance.domain.Player;
import com.nab.finance.repository.PlayerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhu on 15.06.20.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PlayerServiceTest {

    @Autowired
    private IPlayerService playerServiceService;

    @MockBean
    private PlayerRepository playerRepository;


    @Test
    public void listPlayersTest() {

        Player player = new Player();
        List<Player> players = new ArrayList<>();
        players.add(player);

        Mockito.when(playerRepository.findAll()).thenReturn(players);
        Assert.assertNotNull(playerServiceService.listPlayers());

    }


}

