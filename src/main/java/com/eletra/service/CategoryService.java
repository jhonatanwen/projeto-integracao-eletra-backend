package com.eletra.service;

import com.eletra.dto.CategoryDTO;
import com.eletra.model.CategoryEntity;
import com.eletra.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategoriesByLineId(Integer lineId) {
        return categoryRepository.findByLineId(lineId).stream()
                .map(entity -> toDTO(entity, lineId))
                .collect(Collectors.toList());
    }

    public CategoryDTO toDTO(CategoryEntity entity, Integer lineId) {
        return new CategoryDTO(entity.getId(), entity.getName(), lineId);
    }
}
