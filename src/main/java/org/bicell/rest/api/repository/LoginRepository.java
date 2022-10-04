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
    public Boolean loginCheck(String MSISDN, String password) {

        //TODO activate encryption
        //String encryptedPassword=encryption.encryptPassword(password);

        Login login = new Login(MSISDN, password);

        if (MSISDN.equals(MSISDN)  && password.equals(MSISDN)) {
            logger.info("login successful");
            System.out.println("login successful");
//            return new ResponseEntity(login, HttpStatus.OK);
            return true;
        } else {
            logger.info("login unsuccessful");
            System.out.println("login unsuccessful");
//            return new ResponseEntity(login, HttpStatus.BAD_REQUEST);
            return false;
        }
    }
}
