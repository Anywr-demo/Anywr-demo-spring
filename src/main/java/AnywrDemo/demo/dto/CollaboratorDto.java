package AnywrDemo.demo.dto;

import AnywrDemo.demo.Model.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class CollaboratorDto {


    private Long id;
    private String nom;

    private String prenom;

    private String photo;

    private String mail;

    private  String numTel;

    private Date dateNaissance;

    private String motdepasse;

    private Double absenceBalance;


    private List<RoleDto> roles;


    private List<PayementDto> payements;


    private DepartmentDto department;


    private List<AbsenceDto> absences;

    private List<ArticleDto> articles;

    public static CollaboratorDto fromEntity(Collaborateurs collaborateur) {
        if (collaborateur == null) {
            return null;
        }
        return CollaboratorDto.builder()
                .id(collaborateur.getId())
                .dateNaissance(collaborateur.getDateNaissance())
                .department(DepartmentDto.fromEntity(collaborateur.getDepartment()))
                .mail(collaborateur.getMail())
                .nom(collaborateur.getNom())
                .motdepasse(collaborateur.getMotdepasse())
                .numTel(collaborateur.getNumTel())
                .photo(collaborateur.getPhoto())
                .prenom(collaborateur.getPrenom())
                .roles(
                        collaborateur.getRoles() != null ?
                                collaborateur.getRoles().stream()
                                        .map(RoleDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .absenceBalance(collaborateur.getAbsenceBalance())
                .build();
    }

    public static Collaborateurs toEntity(CollaboratorDto collaborateurdto) {

        if (collaborateurdto == null) {
            return null;
        }
        Collaborateurs collab = new Collaborateurs();
        collab.setId(collaborateurdto.getId());
        collab.setNom(collaborateurdto.getNom());
        collab.setPrenom(collaborateurdto.getPrenom());
        collab.setMail(collaborateurdto.getMail());
        collab.setMotdepasse(collaborateurdto.getMotdepasse());
        collab.setNumTel(collaborateurdto.getNumTel());
        collab.setPhoto(collaborateurdto.getPhoto());
        collab.setDateNaissance(collaborateurdto.getDateNaissance());
        collab.setDepartment(DepartmentDto.toEntity(collaborateurdto.getDepartment()));
        collab.setAbsenceBalance(collab.getAbsenceBalance());
        return collab;
    }
}
