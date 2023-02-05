package com.example.web_app_mobilelele.mobiLeLeLe.servicies;

import com.example.web_app_mobilelele.mobiLeLeLe.domain.dtos.UserLoginDTO;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.dtos.UserRegisterDTO;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.entities.User;
import com.example.web_app_mobilelele.mobiLeLeLe.domain.user.CurrentUser;
import com.example.web_app_mobilelele.mobiLeLeLe.repositories.UserRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       CurrentUser currentUser,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

public void registerAndLogin(UserRegisterDTO userRegisterDTO){


        User newUser = new User().
                setActive(true).
                setEmail(userRegisterDTO.getEmail()).
                setFirstName(userRegisterDTO.getFirstName()).
                setLastName(userRegisterDTO.getLastName()).
                setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

       this.userRepository.save(newUser);
       login(newUser);

    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> userOpt = userRepository
                .findByEmail(loginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.info("User with name [{}] not found.", loginDTO.getUsername());
            return false;
        }

        String rawPassword = loginDTO.getPassword();
        String encodedPassword =  userOpt.get().getPassword();

        boolean success = passwordEncoder.
        matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }
        return success;
    }

    private void login(User user) {
        currentUser.
                setLoggedIn(true).
                setName(user.getFirstName() + " " + user.getLastName())
                .setEmail(user.getEmail());
    }

    public void logout() {
        currentUser.clear();
    }
}
