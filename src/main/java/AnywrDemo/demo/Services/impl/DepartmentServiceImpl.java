package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Services.DepartmentService;
import AnywrDemo.demo.dto.AbsenceDto;
import AnywrDemo.demo.dto.DepartmentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public DepartmentDto save(AbsenceDto dto) {
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
