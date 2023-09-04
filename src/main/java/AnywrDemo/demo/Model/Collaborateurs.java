package AnywrDemo.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collaborateurs")
@EqualsAndHashCode(callSuper = true)
public class Collaborateurs extends AbstractEntity implements UserDetails {



    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="photo")
    private String photo;

    @Column(name="mail")
    private String mail;

    @Column(name="numtel")
    private  String numTel;

    @Column(name="date_de_naissance")
    private Date dateNaissance;

    @Column(name="motdepasse")
    private String motdepasse;

    @Column(name = "absence_balance")
    private Double absenceBalance;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Roles> roles = new ArrayList<>();

    @OneToMany(mappedBy = "collaborateurs")
    @JsonIgnore
    private List<Payement> payements;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Departements department;


    @OneToMany(mappedBy = "collaborateurId")
    private List<Absences> absences;

    @OneToMany(mappedBy = "collaborateurs")
    private List<Articles> articles;

    @OneToMany(mappedBy = "createdByCollaborator")
    private List<RefusalReason> createdRefusalReasons;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Roles role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return motdepasse;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}