package AnywrDemo.demo.Services;

import AnywrDemo.demo.dto.AbsenceDto;

import java.util.List;

public interface AbsenceService {

    AbsenceDto save (AbsenceDto dto);


    List<AbsenceDto> findAll();


    AbsenceDto findById(Long id);

    List<AbsenceDto> findHistoriqueAbsence(Long id);

    void delete (Long id);
}
