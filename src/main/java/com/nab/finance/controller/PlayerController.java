package com.nab.finance.controller;

import com.nab.finance.DTO.PlayerDTO;
import com.nab.finance.domain.Player;
import com.nab.finance.service.PlayerService;
import com.nab.finance.service.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by madhu on 15.06.20.
 */

@RestController
@RequestMapping("v1/nab/api/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    /**
     * @param newPlayerDTO
     * @return
     */
    @RequestMapping(value = "/createPlayer", method = RequestMethod.POST)
    public Player createPlayer(@RequestBody PlayerDTO newPlayerDTO) {
        Player newPlayer = playerService.createNewPlayer(newPlayerDTO);
        return newPlayer;
    }

    /**
     *
     */
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Player> getPlayers() {
        return playerService.listPlayers();
    }

    /**
     * @return
     */
    @RequestMapping(value = "/loggedInPlayer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Player> getLoggedPlayer() {
        return new Response<>(playerService.getLoggedUser(), Response.Status.CREATED);
    }


}


