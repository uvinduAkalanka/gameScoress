package com.gamescores.service;

import com.gamescores.dao.GameDao;
import com.gamescores.dao.UserDao;
import com.gamescores.dao.UserGameScoreDao;
import com.gamescores.dao.UserGameScoreJDBCDao;
import com.gamescores.model.domain.UserGameScore;
import com.gamescores.model.dto.GameHighestScoreDTO;
import com.gamescores.model.dto.GameHighestScoreRQ;
import com.gamescores.model.dto.UserGameScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserGameScoreService {

    @Autowired
    private UserGameScoreDao userGameScoreDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GameDao gameDao;

    @Autowired
    private UserGameScoreJDBCDao userGameScoreJDBCDao;

    //Save user game score service logic
    @Transactional(propagation = Propagation.REQUIRED)
    public UserGameScoreDTO saveUserGameScore(UserGameScoreDTO userGameScoreDTO) {
        UserGameScore userGameScore = new UserGameScore();

        userGameScore.setUser(this.userDao.getById(userGameScoreDTO.getUserID()));
        userGameScore.setGame(this.gameDao.getById(userGameScoreDTO.getGameID()));
        userGameScore.setScore(userGameScoreDTO.getScore());

        userGameScore = this.userGameScoreDao.saveAndFlush(userGameScore);

        return new UserGameScoreDTO(userGameScore);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public GameHighestScoreDTO getHighestGameScore(GameHighestScoreRQ scoreRQ) {
        return this.userGameScoreJDBCDao.getHighestGameScore(scoreRQ);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserGameScoreDTO> getTopTenScores(GameHighestScoreRQ scoreRQ) {
        return this.userGameScoreJDBCDao.getTopTenScores(scoreRQ);
    }
}
