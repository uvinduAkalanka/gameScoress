package com.gamescores.model.dto;

import com.gamescores.model.domain.UserGameScore;

public class UserGameScoreDTO {

    private Integer userGameScoreID;

    private Integer userID;

    private Integer gameID;

    private Double score;

    public UserGameScoreDTO() {
    }

    //Parametrized constructor
    public UserGameScoreDTO(UserGameScore userGameScore) {
        this.userGameScoreID = userGameScore.getUserGameScoreID();
        this.userID = userGameScore.getUser().getUserID();
        this.gameID = userGameScore.getGame().getGameID();
        this.score = userGameScore.getScore();
    }

    public Integer getUserGameScoreID() {
        return userGameScoreID;
    }

    public void setUserGameScoreID(Integer userGameScoreID) {
        this.userGameScoreID = userGameScoreID;
    }

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
