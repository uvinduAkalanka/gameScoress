package com.gamescores.model.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity// from this annotation springboot will create table queries
@Table(name = "t_game")
public class Game {

    @Id//primary key of the table
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")//hibernate generated primary key value to auto generation
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "GAME_ID")// columns
    private Integer gameID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
