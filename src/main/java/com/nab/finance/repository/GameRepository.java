package com.nab.finance.repository;

import com.nab.finance.domain.Game;
import com.nab.finance.enums.GameStatus;
import com.nab.finance.enums.GameType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by madhu on 15.06.20.
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findByGameTypeAndGameStatus(GameType GameType, GameStatus GameStatus);

    List<Game> findByGameStatus(GameStatus gameStatus);
}
