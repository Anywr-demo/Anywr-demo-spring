package AnywrDemo.demo.Repository;

import AnywrDemo.demo.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository  extends JpaRepository<Roles,Long> {

    Roles findRoleByRolename(String roleName);


}
