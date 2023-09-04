package AnywrDemo.demo.controller.api;

import AnywrDemo.demo.Utils.Constants;
import AnywrDemo.demo.dto.AbsenceDto;
import AnywrDemo.demo.dto.DepartmentDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DepartmentApi {

    @PostMapping(value = Constants.APP_ROOT +"/department/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    DepartmentDto save (@RequestBody DepartmentDto dto);


    @GetMapping(value = Constants.APP_ROOT + "/department/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<DepartmentDto> findAll();


    @GetMapping(value = Constants.APP_ROOT + "/department/{idDep}")
    DepartmentDto findById(@PathVariable("idDep") Long id);


    @DeleteMapping(value = Constants.APP_ROOT + "/department/delete/{idDep}")
    void delete (@PathVariable("idDep") Long idDep);
}
