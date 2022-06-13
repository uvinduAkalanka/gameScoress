package com.gamescores.service;

import com.gamescores.dao.UserDao;
import com.gamescores.model.domain.User;
import com.gamescores.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //Save user service logic
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDTO saveUser(UserDTO saveUserDTO) {
        User user = new User();

        user.setUserName(saveUserDTO.getUserName());
        user.setEmail(saveUserDTO.getEmail());

        user = this.userDao.saveAndFlush(user);

        return new UserDTO(user);
    }
}
