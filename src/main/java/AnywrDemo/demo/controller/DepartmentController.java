package AnywrDemo.demo.controller;

import AnywrDemo.demo.controller.api.DepartmentApi;
import AnywrDemo.demo.dto.AbsenceDto;
import AnywrDemo.demo.dto.DepartmentDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController implements DepartmentApi {
    @Override
    public DepartmentDto save(DepartmentDto dto) {
        return null;
    }

    @Override
    public List<DepartmentDto> findAll() {
        return null;
    }

    @Override
    public DepartmentDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
