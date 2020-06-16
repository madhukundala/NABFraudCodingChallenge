package com.nab.finance.DTO;

import com.nab.finance.enums.GameStatus;
import com.nab.finance.enums.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by patrycja on 15.06.20.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveDTO {

    private int boardColumn;

    private int boardRow;

    private Date created;

    private String userName;

    private GameStatus gameStatus;

    private Piece playerPieceCode;
}
