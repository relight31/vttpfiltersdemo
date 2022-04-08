package vttp.demo.login.repository;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static vttp.demo.login.repository.Queries.*;

@Repository
public class LoginRepo {

    @Autowired
    JdbcTemplate template;

    Logger logger = Logger.getLogger(LoginRepo.class.getName());

    public boolean authenticate(String username, String password) {
        logger.log(Level.INFO, "Making SQL query with username " + username + " and password " + password);
        SqlRowSet result = template.queryForRowSet(SQL_AUTHENTICATE_USER, username, password);
        logger.log(Level.INFO, "Result returned from DB");
        if (result.next()) {
            logger.log(Level.INFO, "Authenticated username " + username);
            return result.getInt("auth") == 1;
        }
        return false;
    }
}
