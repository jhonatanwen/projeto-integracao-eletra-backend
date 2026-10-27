package com.eletra.service;

import com.eletra.dto.LineDTO;
import com.eletra.model.LineEntity;
import com.eletra.repository.LineRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {
    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public List<LineDTO> getAllLines() {
        return lineRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    private LineDTO toDTO(LineEntity entity) {
        return new LineDTO(entity.getId(), entity.getName());
    }
}
