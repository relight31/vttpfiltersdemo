package vttp.demo.login.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vttp.demo.login.services.LoginService;

@Controller
@RequestMapping
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    LoginService loginService;

    @GetMapping(path = "/logout")
    public String logout(HttpSession session) {
        logger.log(Level.INFO, "Clearing session");
        session.invalidate();
        logger.log(Level.INFO, "Session cleared, returning to login page");
        return "index";
    }

    @PostMapping(path = "/authenticate")
    public ModelAndView authenticate(
            @RequestBody MultiValueMap<String, String> form,
            HttpSession session) {
        ModelAndView mav = new ModelAndView();
        if (loginService.authenticate(
                form.getFirst("username"),
                form.getFirst("password"))) {
            logger.log(Level.INFO, "Successfully authenticated");
            // add attribute to session so it can be retrieved across controllers
            session.setAttribute("username", form.getFirst("username"));
            mav.setViewName("redirect:/protected/success");
            ;
        } else {
            logger.log(Level.INFO, "Authentication failed");
            mav.setStatus(HttpStatus.UNAUTHORIZED);
            mav.addObject("message", "Incorrect username or password");
            mav.setViewName("index");
        }
        return mav;
    }
}
