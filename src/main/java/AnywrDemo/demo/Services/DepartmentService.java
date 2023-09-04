package AnywrDemo.demo.Services;

import AnywrDemo.demo.dto.AbsenceDto;
import AnywrDemo.demo.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto save (AbsenceDto dto);


    List<DepartmentDto> findAll();


    DepartmentDto findById(Long id);


    void delete (Long id);
}
