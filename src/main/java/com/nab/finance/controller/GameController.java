package com.nab.finance.controller;

import com.nab.finance.DTO.GameDTO;
import com.nab.finance.domain.Game;
import com.nab.finance.service.GameService;
import com.nab.finance.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by madhu on 15.06.20.
 */

@RestController
@RequestMapping("v1/nab/api/game")
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    PlayerService playerService;


    Logger logger = LoggerFactory.getLogger(GameController.class);

    /**
     * @param gameDTO
     * @return
     */
    @RequestMapping(value = "/createGame", method = RequestMethod.POST)
    public Game createNewGame(@RequestBody GameDTO gameDTO) {

        Game game = gameService.createNewGame(playerService.getLoggedUser(), gameDTO);

        return game;
    }

    /**
     * @return
     */
    @RequestMapping(value = "/listGames", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> getGamesToJoin() {
        return gameService.getGamesToJoin(playerService.getLoggedUser());
    }

    /**
     * @param gameDTO
     * @return
     */
    @RequestMapping(value = "/joinGame", method = RequestMethod.POST)
    public Game joinGame(@RequestBody GameDTO gameDTO) {
        Game game = gameService.joinGame(playerService.getLoggedUser(), gameDTO);
        return game;
    }

    /**
     * @return
     */
    @RequestMapping(value = "/player/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Game> getPlayerGames() {
        return gameService.getPlayerGames(playerService.getLoggedUser());
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}")
    public Game getGameProperties(@PathVariable Long id) {

        return gameService.getGame(id);
    }


}
