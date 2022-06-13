package com.gamescores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.gamescores.model.domain")// need to give where are the entities are
public class GamescoresApplication {

    //This is main method application run start with this
    public static void main(String[] args) {
        SpringApplication.run(GamescoresApplication.class, args);
    }

}
