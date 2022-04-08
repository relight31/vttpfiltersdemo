package vttp.demo.login.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.demo.login.repository.LoginRepo;

@Service
public class LoginService {
    Logger logger = Logger.getLogger(LoginService.class.getName());

    @Autowired
    LoginRepo loginRepo;

    public boolean authenticate(String username, String password) {
        logger.log(Level.INFO, "Calling loginRepo.authenticate method");
        return loginRepo.authenticate(username, password);
    }
}
