package com.eletra.controller;

import com.eletra.dto.ModelDTO;
import com.eletra.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/models")
@Tag(name = "Models", description = "Endpoint de modelos dos medidores")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) { this.modelService = modelService; }

    @GetMapping("/categories/{categoryId}")
    @Operation(summary = "Lista os modelos dos medidores de acordo com sua categoria")
    public ResponseEntity<List<ModelDTO>> getModelsByCategoryId(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(modelService.getModelsByCategoryId(categoryId));
    }
}
