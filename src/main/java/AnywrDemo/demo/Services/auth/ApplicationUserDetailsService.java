package AnywrDemo.demo.Services.auth;

import AnywrDemo.demo.Model.Collaborateurs;
import AnywrDemo.demo.Model.auth.ExtendedUser;
import AnywrDemo.demo.Repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private CollaboratorRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       Collaborateurs user =  userRepository.findCollaborateursByMail(email).orElseThrow(null);

       List<SimpleGrantedAuthority> authorities = new ArrayList<>();
       user.getRoles().forEach(roles -> authorities.add(new SimpleGrantedAuthority(roles.getRolename())));
        return new ExtendedUser(user.getMail(),user.getMotdepasse(),user.getId(), authorities);
    }
}
