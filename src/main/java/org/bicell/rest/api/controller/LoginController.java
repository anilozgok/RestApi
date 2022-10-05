package org.bicell.rest.api.controller;

import org.bicell.rest.api.encryption.Encryption;
import org.bicell.rest.api.entity.Login;
import org.bicell.rest.api.repository.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin //for CORS
@RequestMapping("/login")
public class LoginController {

    LoginRepository loginRepository = new LoginRepository();
    Encryption encryption=new Encryption();

    @PostMapping("/")
    public ResponseEntity login(@RequestBody Login memberLogin) throws Exception{

        return loginRepository.loginCheck(memberLogin.getMsisdn(), encryption.encryptPassword(memberLogin.getPassword()));

    }

    /*
    @PostMapping("/android")
    public Boolean loginAndroid(@RequestBody Login memberlogin){
        return loginRepository.loginCheck(memberlogin.getMSISDN(), encryption.encryptPassword(memberlogin.getPassword()));
    }*/

}
