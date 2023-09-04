package AnywrDemo.demo.controller.api;

import AnywrDemo.demo.Utils.Constants;
import AnywrDemo.demo.dto.AbsenceDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

public interface AbsenceApi {


    @PostMapping(value = Constants.APP_ROOT + "/absence/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    AbsenceDto save (@RequestBody AbsenceDto dto);



    @GetMapping(value = Constants.APP_ROOT + "/absence/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<AbsenceDto> findAll();


    @GetMapping(value = Constants.APP_ROOT + "/absence/{idAbsence}", produces = MediaType.APPLICATION_JSON_VALUE)
    AbsenceDto findById(@PathVariable("idAbsence") Long idAbsence);

    @GetMapping(value = Constants.APP_ROOT + "/absence/historique/{idAbsence}" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<AbsenceDto> findHistoriqueAbsence(@PathVariable("idAbsence") Long idAbsence);


    @DeleteMapping(value = Constants.APP_ROOT + "/absence/delete/{idAbsence}")

    void delete (@PathVariable("idAbsence") Long idAbsence);
}
