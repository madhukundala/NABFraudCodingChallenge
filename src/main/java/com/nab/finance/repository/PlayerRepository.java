package com.nab.finance.repository;

import com.nab.finance.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by patrycja on 15.06.20.
 */
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findOneByUserName(String userName);
}
