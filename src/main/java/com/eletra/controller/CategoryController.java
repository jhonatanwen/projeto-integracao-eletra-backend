package com.eletra.controller;

import com.eletra.model.CategoryEntity;
import com.eletra.repository.CategoryRepository;

import java.util.List;

public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController() {
        this.categoryRepository = new CategoryRepository();
    }

    public List<CategoryEntity>getCategoriesByLineId(Integer lineId) {
        return categoryRepository.findByLineId(lineId);
    }
}
