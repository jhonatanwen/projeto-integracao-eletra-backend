package com.eletra.controller;

import com.eletra.model.ModelEntity;
import com.eletra.repository.ModelRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/model")
@Tag(name = "Models", description = "Endpoint de modelos dos medidores")
public class ModelController {
    private final ModelRepository modelRepository;

    public ModelController() {
        this.modelRepository = new ModelRepository();
    }

    @GetMapping
    @Operation
    public ResponseEntity<List<ModelEntity>> getModelsByCategoryId(Integer categoryId) {
        return ResponseEntity.ok(modelRepository.findByCategoryId(categoryId));
    }
}
