package AnywrDemo.demo.Services.impl;

import AnywrDemo.demo.Services.DemandeArticleService;
import AnywrDemo.demo.dto.DemandeArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DemandeArticleServiceImpl implements DemandeArticleService {
    @Override
    public DemandeArticleDto save(DemandeArticleDto dto) {
        return null;
    }

    @Override
    public List<DemandeArticleDto> findAll() {
        return null;
    }

    @Override
    public DemandeArticleDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
