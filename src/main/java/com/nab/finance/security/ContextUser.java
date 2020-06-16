package com.nab.finance.security;

import com.google.common.collect.ImmutableSet;
import com.nab.finance.domain.Player;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Created by madhu on 15.06.20.
 */
public class ContextUser extends org.springframework.security.core.userdetails.User {

    private final Player player;

    public ContextUser(Player player) {
        super(player.getUserName(),
                player.getPassword(),
                true,
                true,
                true,
                true,
                ImmutableSet.of(new SimpleGrantedAuthority("create")));

        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
