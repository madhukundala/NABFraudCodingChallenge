package com.nab.finance.controller;

import com.nab.finance.DTO.CreateMoveDTO;
import com.nab.finance.DTO.MoveDTO;
import com.nab.finance.domain.Game;
import com.nab.finance.domain.Move;
import com.nab.finance.domain.Position;
import com.nab.finance.service.GameService;
import com.nab.finance.service.MoveService;
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
@RequestMapping("v1/nab/api/move")
public class MoveController {

    Logger logger = LoggerFactory.getLogger(MoveController.class);
    @Autowired
    private MoveService moveService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    /**
     * @param createMoveDTO
     * @return
     */
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Move createMove(@RequestBody CreateMoveDTO createMoveDTO) {
        logger.info("move to insert:" + createMoveDTO.getBoardColumn() + createMoveDTO.getBoardRow());

        Move move = moveService.createMove(gameService.getGame(createMoveDTO.getGameId()), playerService.getLoggedUser(), createMoveDTO);
        Game game = gameService.getGame(createMoveDTO.getGameId());
        gameService.updateGameStatus(gameService.getGame(createMoveDTO.getGameId()), moveService.checkCurrentGameStatus(game));

        return move;
    }


    /**
     * @return
     */
    @GetMapping(value = "/listMoves", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MoveDTO> getMovesInGame(@RequestParam(value = "gameId") Long gameId) {

        return moveService.getMovesInGame(gameService.getGame(gameId));
    }

    /**
     * @return
     */
    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Position> validateMoves(@RequestParam(value = "gameId") Long gameId) {
        return moveService.getPlayerMovePositionsInGame(gameService.getGame(gameId), playerService.getLoggedUser());
    }

    /**
     * @return
     */
    @GetMapping(value = "/playerTurn", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isPlayerTurn(@RequestParam(value = "gameId") Long gameId) {
        return moveService.isPlayerTurn(gameService.getGame(gameId), gameService.getGame(gameId).getFirstPlayer(),
                gameService.getGame(gameId).getSecondPlayer());
    }


}
