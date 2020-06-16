package com.nab.finance;

import com.nab.finance.domain.Player;
import com.nab.finance.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class TicTacToeGameApplication {


    public static void main(String[] args) {
        SpringApplication.run(TicTacToeGameApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PlayerRepository playerRepository) {
        return (args) -> {

            //save a couple of players
            playerRepository.save(new Player("ala", "ala@ala.com", new BCryptPasswordEncoder().encode("ala")));
            playerRepository.save(new Player("mary", "mary@mary.com", new BCryptPasswordEncoder().encode("mary")));

        };
    }

}
