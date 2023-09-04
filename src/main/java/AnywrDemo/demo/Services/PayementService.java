package AnywrDemo.demo.Services;

import AnywrDemo.demo.dto.PayementDto;

import java.util.List;

public interface PayementService {

    PayementDto save(PayementDto dto);

    PayementDto findById(Long id);

    List<PayementDto> findAll();

    void delete(Integer id);

}
