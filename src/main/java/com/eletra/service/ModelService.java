package com.eletra.service;

import com.eletra.dto.ModelDTO;
import com.eletra.model.ModelEntity;
import com.eletra.repository.ModelRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<ModelDTO> getModelsByCategoryId(Integer categoryId) {
        return modelRepository.findByCategoryId(categoryId).stream()
                .map(entity -> toDTO(entity, categoryId))
                .collect(Collectors.toList());
    }

    public ModelDTO toDTO(ModelEntity entity, Integer categoryId) {
        return new ModelDTO(entity.getId(), entity.getName(), categoryId);
    }
}
