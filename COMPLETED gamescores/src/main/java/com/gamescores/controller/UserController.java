package com.gamescores.controller;

import com.gamescores.model.dto.ResponseDTO;
import com.gamescores.model.dto.UserDTO;
import com.gamescores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Save user rest API
    @RequestMapping(value = "/saveUser", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO<UserDTO>> saveUser(@RequestBody UserDTO saveUserDTO) {

        ResponseDTO<UserDTO> response = new ResponseDTO<>();

        try {
            UserDTO userDTO = this.userService.saveUser(saveUserDTO);

            response.setStatus("SUCCESS");
            response.setResult(userDTO);
        } catch (Exception e) {
            response.setStatus("FAILED");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
