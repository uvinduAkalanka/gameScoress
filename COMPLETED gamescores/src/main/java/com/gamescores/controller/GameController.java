package com.gamescores.controller;

import com.gamescores.model.dto.GameDTO;
import com.gamescores.model.dto.ResponseDTO;
import com.gamescores.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    //Save game rest API
    @RequestMapping(value = "/saveGame", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO<GameDTO>> saveGame(@RequestBody GameDTO saveGameDTO) {

        ResponseDTO<GameDTO> response = new ResponseDTO<>();

        try {
            GameDTO gameDTO = this.gameService.saveGame(saveGameDTO);

            response.setStatus("SUCCESS");
            response.setResult(gameDTO);
        } catch (Exception e) {
            response.setStatus("FAILED");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
