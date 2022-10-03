package org.bicell.rest.api.repository;

import org.bicell.rest.api.encryption.Encryption;
import org.bicell.rest.api.entity.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.logging.Logger;


public class LoginRepository {
    Logger logger = Logger.getLogger(LoginRepository.class.getName());

    Encryption encryption = new Encryption();

    //TODO login logic will we implemented after oracele helper implementations. This is a temporary dummy login logic.
    public ResponseEntity loginCheck(String MSISDN, String password) {

        String encryptedPassword=encryption.encryptPassword(password);

        Login login = new Login(MSISDN, password);

        if (login.getMSISDN() == password && login.getPassword() == encryptedPassword) {
            logger.info("login successful");
            return new ResponseEntity(login, HttpStatus.OK);
        } else {
            logger.info("login unsuccessful");
            return new ResponseEntity(login, HttpStatus.BAD_REQUEST);
        }
    }
}
