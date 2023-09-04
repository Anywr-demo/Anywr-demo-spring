package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.Collaborateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CollaboratorRepository extends JpaRepository<Collaborateurs,Long> {

    @Query(value = "select u from Collaborateurs u where u.mail = :email")
    Optional<Collaborateurs> findCollaborateursByMail(@Param("email") String email);


    public Collaborateurs findByResetPasswordToken(String token);

}
