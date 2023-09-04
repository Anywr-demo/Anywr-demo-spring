package AnywrDemo.demo.Model.auth;

import AnywrDemo.demo.Model.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExtendedUser extends User {
     @Getter
    @Setter

    private Long idUser;

     public  ExtendedUser(String username , String password , Collection<? extends GrantedAuthority> authorities)
     {
         super(username,password,authorities);
     }

     public ExtendedUser(String username , String password , Long idUser ,  Collection<? extends GrantedAuthority> authorities)
     {
         super(username,password,authorities);
         this.idUser = idUser;
     }

}
