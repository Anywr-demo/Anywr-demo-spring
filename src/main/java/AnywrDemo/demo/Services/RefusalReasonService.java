package AnywrDemo.demo.Services;

import AnywrDemo.demo.dto.RefusalReasonDto;

import java.util.List;

public interface RefusalReasonService {

    RefusalReasonDto save(RefusalReasonDto dto);

    RefusalReasonDto findById(Integer id);

    List<RefusalReasonDto> findAll();

    void delete(Integer id);

}
