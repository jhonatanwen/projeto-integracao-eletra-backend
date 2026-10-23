package com.eletra.controller;

import com.eletra.model.ModelEntity;
import com.eletra.repository.ModelRepository;

import java.util.List;

public class ModelController {
    private final ModelRepository modelRepository;

    public ModelController() {
        this.modelRepository = new ModelRepository();
    }

    public List<ModelEntity> getModelsByCategoryId(Integer categoryId) {
        return modelRepository.findByCategoryId(categoryId);
    }
}
