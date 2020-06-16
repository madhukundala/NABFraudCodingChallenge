package com.nab.finance;

import com.nab.finance.domain.Player;
import com.nab.finance.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class TicTacToeApplication {


    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PlayerRepository playerRepository) {
        return (args) -> {

            //save a couple of players
            playerRepository.save(new Player("john", "john@gmail.com", new BCryptPasswordEncoder().encode("john")));
            playerRepository.save(new Player("paul", "paul@gmail.com", new BCryptPasswordEncoder().encode("paul")));

        };
    }

}
