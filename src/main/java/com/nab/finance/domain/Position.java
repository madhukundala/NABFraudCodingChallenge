package com.nab.finance.domain;

import lombok.*;

/**
 * Created by madhu on 15.06.20.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {
    int boardRow;
    int boardColumn;
}
