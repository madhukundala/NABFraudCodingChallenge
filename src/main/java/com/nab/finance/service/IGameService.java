package com.nab.finance.service;

import com.nab.finance.DTO.GameDTO;
import com.nab.finance.domain.Game;
import com.nab.finance.domain.Player;

import java.util.List;

public interface IGameService {

    Game createNewGame(Player player, GameDTO gameDTO);

    List<Game> getGamesToJoin(Player player);

    Game joinGame(Player player, GameDTO gameDTO);

    List<Game> getPlayerGames(Player player);

    Game getGame(Long id);
}
