package AnywrDemo.demo.Services;

import AnywrDemo.demo.dto.AbsenceDto;
import AnywrDemo.demo.dto.DemandeArticleDto;

import java.util.List;

public interface DemandeArticleService {

    DemandeArticleDto save (DemandeArticleDto dto);


    List<DemandeArticleDto> findAll();


    DemandeArticleDto findById(Long id);


    void delete (Long id);
}
