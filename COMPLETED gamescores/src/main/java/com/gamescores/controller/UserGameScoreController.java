package com.gamescores.controller;

import com.gamescores.model.dto.GameHighestScoreDTO;
import com.gamescores.model.dto.GameHighestScoreRQ;
import com.gamescores.model.dto.ResponseDTO;
import com.gamescores.model.dto.UserGameScoreDTO;
import com.gamescores.service.UserGameScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/user-game-score")
public class UserGameScoreController {

    @Autowired
    private UserGameScoreService userGameScoreService;

    //Save user game score rest API
    @RequestMapping(value = "/saveUserGameScore", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO<UserGameScoreDTO>> saveUserGameScore(@RequestBody UserGameScoreDTO userGameScoreDTO) {

        ResponseDTO<UserGameScoreDTO> response = new ResponseDTO<>();

        try {
            UserGameScoreDTO result = this.userGameScoreService.saveUserGameScore(userGameScoreDTO);

            response.setStatus("SUCCESS");
            response.setResult(result);
        } catch (Exception e) {
            response.setStatus("FAILED");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Get Highest score rest API
    @RequestMapping(value = "/getHighestGameScore", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO<GameHighestScoreDTO>> getHighestGameScore(@RequestBody GameHighestScoreRQ scoreRQ) {

        ResponseDTO<GameHighestScoreDTO> response = new ResponseDTO<>();

        try {
            GameHighestScoreDTO result = this.userGameScoreService.getHighestGameScore(scoreRQ);

            response.setStatus("SUCCESS");
            response.setResult(result);
        } catch (Exception e) {
            response.setStatus("FAILED");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Get Highest score rest API
    @RequestMapping(value = "/getTopTenScores", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO<List<UserGameScoreDTO>>> getTopTenScores(@RequestBody GameHighestScoreRQ scoreRQ) {

        ResponseDTO<List<UserGameScoreDTO>> response = new ResponseDTO<>();

        try {
            List<UserGameScoreDTO> results = this.userGameScoreService.getTopTenScores(scoreRQ);

            response.setStatus("SUCCESS");
            response.setResult(results);
        } catch (Exception e) {
            response.setStatus("FAILED");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
