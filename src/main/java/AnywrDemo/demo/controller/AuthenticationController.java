package AnywrDemo.demo.controller;

import AnywrDemo.demo.Model.auth.ExtendedUser;
import AnywrDemo.demo.Services.CollaborateurService;
import AnywrDemo.demo.Services.auth.ApplicationUserDetailsService;
import AnywrDemo.demo.Utils.Constants;
import AnywrDemo.demo.Utils.JwtUtil;
import AnywrDemo.demo.controller.api.AuthenticationApi;
import AnywrDemo.demo.dto.auth.AuthenticationRequest;
import AnywrDemo.demo.dto.auth.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController implements AuthenticationApi {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;


    private CollaborateurService collaborateurService;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
    {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());


        String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        String message = "Hello, you have the following role(s): " + String.join(", ", roles);



        return ResponseEntity.ok(new AuthenticationResponse(jwt,
                ((ExtendedUser) userDetails).getIdUser(),
                userDetails.getUsername(),
                roles,
                message));

    }


}
