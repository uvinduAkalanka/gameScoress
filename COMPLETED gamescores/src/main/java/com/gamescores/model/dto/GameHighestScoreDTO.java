package com.gamescores.model.dto;

public class GameHighestScoreDTO {

    private Integer userID;

    private Integer gameID;

    private Double heightScore;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public Double getHeightScore() {
        return heightScore;
    }

    public void setHeightScore(Double heightScore) {
        this.heightScore = heightScore;
    }
}
