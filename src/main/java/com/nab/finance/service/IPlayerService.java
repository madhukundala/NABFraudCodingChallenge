package com.nab.finance.service;

import com.nab.finance.DTO.PlayerDTO;
import com.nab.finance.domain.Player;

import java.util.List;

public interface IPlayerService {

    List<Player> listPlayers();

    Player createNewPlayer(PlayerDTO playerDTO);

}
