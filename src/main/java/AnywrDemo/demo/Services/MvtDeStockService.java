package AnywrDemo.demo.Services;

import AnywrDemo.demo.Model.MvtDeStock;
import AnywrDemo.demo.dto.MvtDeStkDto;

import java.util.List;

public interface MvtDeStockService {

    MvtDeStkDto save(MvtDeStkDto dto);

    MvtDeStkDto findById(Integer id);

    List<MvtDeStkDto> findAll();

    void delete(Integer id);

}
