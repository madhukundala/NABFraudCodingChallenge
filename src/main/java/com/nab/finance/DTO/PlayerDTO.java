package com.nab.finance.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


/**
 * Created by madhu on 15.06.20.
 */

@Getter
@Setter
public class PlayerDTO {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String email;
}
