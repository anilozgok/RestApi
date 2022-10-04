package org.bicell.rest.api.controller.Login;

import org.springframework.http.ResponseEntity;

public interface Login {
    Boolean loginCheck(String MSISDN, String password);
}
