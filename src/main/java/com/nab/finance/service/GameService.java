package com.nab.finance.service;

import com.nab.finance.DTO.GameDTO;
import com.nab.finance.domain.Game;
import com.nab.finance.domain.Player;
import com.nab.finance.enums.GameStatus;
import com.nab.finance.enums.GameType;
import com.nab.finance.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by madhu on 15.06.20.
 */
@Service
@Transactional
public class GameService implements IGameService {

    @Autowired
    private GameRepository gameRepository;

    /**
     * @param player
     * @param gameDTO
     * @return
     */
    public Game createNewGame(Player player, GameDTO gameDTO) {
        Game game = new Game();
        game.setFirstPlayer(player);
        game.setGameType(gameDTO.getGameType());
        game.setFirstPlayerPieceCode(gameDTO.getPiece());
        game.setGameStatus(GameStatus.WAITS_FOR_PLAYER);

        game.setCreated(new Date());
        gameRepository.save(game);

        return game;
    }


    /**
     * @param game
     * @param gameStatus
     * @return
     */
    public Game updateGameStatus(Game game, GameStatus gameStatus) {
        Game g = getGame(game.getGameId());
        g.setGameStatus(gameStatus);

        return g;
    }

    /**
     * @param player
     * @return
     */
    public List<Game> getGamesToJoin(Player player) {
        return gameRepository.findByGameTypeAndGameStatus(GameType.COMPETITION,
                GameStatus.WAITS_FOR_PLAYER).stream().filter(game -> game.getFirstPlayer() != player).collect(Collectors.toList());

    }

    /**
     * @param player
     * @param gameDTO
     * @return
     */
    public Game joinGame(Player player, GameDTO gameDTO) {
        Game game = getGame((long) gameDTO.getGameId());
        game.setSecondPlayer(player);
        gameRepository.save(game);

        updateGameStatus(game, GameStatus.IN_PROGRESS);

        return game;

    }

    /**
     * @param player
     * @return
     */
    public List<Game> getPlayerGames(Player player) {
        return gameRepository.findByGameStatus(
                GameStatus.IN_PROGRESS).stream().filter(game -> game.getFirstPlayer() == player).collect(Collectors.toList());
    }


    /**
     * @param id
     * @return
     */
    public Game getGame(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) {
            return game.get();
        } else {
            return null;
        }
    }
}
