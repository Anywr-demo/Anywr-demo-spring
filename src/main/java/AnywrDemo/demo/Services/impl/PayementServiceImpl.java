package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Services.PayementService;
import AnywrDemo.demo.dto.PayementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PayementServiceImpl implements PayementService {
    @Override
    public PayementDto save(PayementDto dto) {
        return null;
    }

    @Override
    public PayementDto findById(Long id) {
        return null;
    }

    @Override
    public List<PayementDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
