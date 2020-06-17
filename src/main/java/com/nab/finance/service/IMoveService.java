package com.nab.finance.service;

import com.nab.finance.DTO.CreateMoveDTO;
import com.nab.finance.DTO.MoveDTO;
import com.nab.finance.domain.Game;
import com.nab.finance.domain.Move;
import com.nab.finance.domain.Player;
import com.nab.finance.domain.Position;
import com.nab.finance.enums.GameStatus;

import java.util.List;

public interface IMoveService {

    Move createMove(Game game, Player player, CreateMoveDTO createMoveDTO);

    List<MoveDTO> getMovesInGame(Game game);

    List<Position> getPlayerMovePositionsInGame(Game game, Player player);

    boolean isPlayerTurn(Game game, Player firstPlayer, Player secondPlayer);

    GameStatus checkCurrentGameStatus(Game game);
}
