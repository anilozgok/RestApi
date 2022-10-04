package org.bicell.rest.api.controller.Login;

import org.bicell.rest.api.repository.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/login")
@CrossOrigin //for CORS
public class LoginControllerWeb implements Login {

    LoginRepository loginRepository = new LoginRepository();

    /**
     * Login check for web
     * @param MSISDN Mobile Station International Subscriber Directory Number
     * @param password Password
     * @return ResponseEntity
     */
    @GetMapping("/{MSISDN}/{password}")
    @Override
    public ResponseEntity loginCheck(@PathVariable String MSISDN, @PathVariable String password) {
        return this.loginCheckWeb(MSISDN,password);
    }

    private ResponseEntity loginCheckWeb(String MSISDN, String password) {
        return loginRepository.loginCheck(MSISDN,password);
    }
}
