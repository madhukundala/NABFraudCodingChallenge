package com.nab.finance.repository;

import com.nab.finance.domain.Game;
import com.nab.finance.domain.Move;
import com.nab.finance.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by madhu on 15.06.20.
 */
@Repository
public interface MoveRepository extends CrudRepository<Move, Long> {

    List<Move> findByGame(Game game);

    List<Move> findByGameAndPlayer(Game game, Player player);

    int countByGameAndPlayer(Game game, Player player);
}
