package com.gamescores.service;

import com.gamescores.dao.GameDao;
import com.gamescores.model.domain.Game;
import com.gamescores.model.dto.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    //Save game service logic
    @Transactional(propagation = Propagation.REQUIRED)
    public GameDTO saveGame(GameDTO saveGameDTO) {
        Game game = new Game();

        game.setName(saveGameDTO.getName());
        game.setDescription(saveGameDTO.getDescription());

        game = this.gameDao.saveAndFlush(game);

        return new GameDTO(game);
    }
}
