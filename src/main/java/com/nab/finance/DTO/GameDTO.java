package com.nab.finance.DTO;

import com.nab.finance.enums.GameType;
import com.nab.finance.enums.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by madhu on 15.06.20.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private GameType gameType;

    private Piece piece;

    private Long gameId;
}


