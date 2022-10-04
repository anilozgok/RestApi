package org.bicell.rest.api.controller.Login;

import org.bicell.rest.api.repository.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //for CORS
@RequestMapping("/login")
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
    public Boolean loginCheck(@PathVariable String MSISDN, @PathVariable String password) {
        System.out.println(MSISDN+"\n"+password);
        return this.loginCheckWeb(MSISDN,password);
    }

    private Boolean loginCheckWeb(String MSISDN, String password) {
        return loginRepository.loginCheck(MSISDN,password);
    }
}
