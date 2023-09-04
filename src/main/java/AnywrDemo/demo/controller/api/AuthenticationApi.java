package AnywrDemo.demo.controller.api;

import AnywrDemo.demo.Utils.Constants;
import AnywrDemo.demo.dto.auth.AuthenticationRequest;
import AnywrDemo.demo.dto.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationApi {

    @PostMapping(Constants.AUTHENTICATION_ENDPOINT+ "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);
}
