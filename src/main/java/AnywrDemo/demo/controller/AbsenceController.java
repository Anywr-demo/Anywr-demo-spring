package AnywrDemo.demo.controller;

import AnywrDemo.demo.Services.AbsenceService;
import AnywrDemo.demo.controller.api.AbsenceApi;
import AnywrDemo.demo.dto.AbsenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AbsenceController implements AbsenceApi {
    AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService)
    {
        this.absenceService = absenceService;
    }

    @Override
    public AbsenceDto save(AbsenceDto dto) {
        return  absenceService.save(dto);
    }

    @Override
    public List<AbsenceDto> findAll() {
        return absenceService.findAll();
    }

    @Override
    public AbsenceDto findById(Long id) {
        return absenceService.findById(id);
    }

    @Override
    public List<AbsenceDto> findHistoriqueAbsence(Long id) {
        return absenceService.findHistoriqueAbsence(id);
    }

    @Override
    public void delete(Long id) {
        absenceService.delete(id);
    }
}
