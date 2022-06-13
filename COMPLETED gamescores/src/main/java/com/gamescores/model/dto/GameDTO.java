package com.gamescores.model.dto;

import com.gamescores.model.domain.Game;

public class GameDTO {

    private Integer gameID;

    private String name;

    private String description;

    public GameDTO() {
    }

    //Parametrized constructor
    public GameDTO(Game game) {
        this.gameID = game.getGameID();
        this.name = game.getName();
        this.description = game.getDescription();
    }

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
