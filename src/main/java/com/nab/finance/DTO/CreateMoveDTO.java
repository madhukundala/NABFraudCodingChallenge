package com.nab.finance.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by madhu on 15.06.20.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMoveDTO {

    @NotNull
    int boardRow;

    @NotNull
    int boardColumn;

    @NotNull
    private Long gameId;

}
